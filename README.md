## Application logic
- Application publishes messages to "simple-producer" Topic with SimpleProducer code.
- Read messages from "simple-producer", transform to upper case and publishes to "simple-consumer" Topic with SimpleStream code.
- Read messages from "simple-consumer" Topic with SimpleConsumer code.

## Start Zookeeper:
`bin/zookeeper-server-start.sh config/zookeeper.properties`

## Start Kafka:
`bin/kafka-server-start.sh config/server.properties`

## Create Topic:
`bin/kafka-topics.sh --create --topic simple-producer --bootstrap-server localhost:9092`

## Describe Topic:
`bin/kafka-topics.sh --describe --topic simple-producer --bootstrap-server localhost:9092`

## Publish Events:
`bin/kafka-console-producer.sh --topic simple-producer --bootstrap-server localhost:9092`

## Create Topic:
`bin/kafka-topics.sh --create --topic simple-consumer --bootstrap-server localhost:9092`

## Describe Topic:
`bin/kafka-topics.sh --describe --topic simple-consumer --bootstrap-server localhost:9092`

## Read Events:
`bin/kafka-console-consumer.sh --topic simple-consumer --from-beginning --bootstrap-server localhost:9092`

## Producer and Consumer Examples are from:
[https://www.sohamkamani.com/java/kafka/](https://www.sohamkamani.com/java/kafka/)

## Streams:
[https://www.baeldung.com/java-kafka-streams-vs-kafka-consumer](https://www.baeldung.com/java-kafka-streams-vs-kafka-consumer)

## Start Kafdrop:
`java -jar kafdrop-3.30.0.jar --kafka.brokerConnect=localhost:9092`
### Open in Browser:
[http://localhost:9000/](http://localhost:9000/)