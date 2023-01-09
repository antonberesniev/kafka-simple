public class App {

    public static final String INPUT_TOPIC = "simple-producer";
    public static final String OUTPUT_TOPIC = "simple-consumer";
    public static final String BOOTSTRAP_SERVERS = "localhost:9092";


    public static void main(String[] args) {
        Thread consumerThread = new Thread(SimpleConsumer::readEvents);
        consumerThread.start();

        Thread streamThread = new Thread(SimpleStream::runSimpleStream);
        streamThread.start();

        Thread producerThread = new Thread(SimpleProducer::publishEvents);
        producerThread.start();
    }
}
