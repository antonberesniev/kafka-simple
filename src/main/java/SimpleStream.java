import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Properties;
public class SimpleStream {


    public static void main(String[] args) {
        runSimpleStream();
    }

    public static void runSimpleStream() {
        final StreamsBuilder builder = new StreamsBuilder();
        builder.stream(App.INPUT_TOPIC, Consumed.with(Serdes.String(), Serdes.String()))
                .mapValues(v -> {
                    var res = v.toUpperCase();
                    System.out.println("Stream converts from \"" + v+ "\" to \"" + res + "\"");
                    return res;
                })
                .to(App.OUTPUT_TOPIC, Produced.with(Serdes.String(), Serdes.String()));

        final KafkaStreams streams = new KafkaStreams(builder.build(), getProperties());
        streams.start();

    }

    private static Properties getProperties() {
        final Properties streamsConfiguration = new Properties();
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "simple-java-project");
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, App.BOOTSTRAP_SERVERS);
        return streamsConfiguration;
    }
}
