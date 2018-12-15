package br.com.quintoandar.springcloudgcppubsubexample.consumers;

import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;

public interface PubSubConsumer {

    String subscription();

    void consume(BasicAcknowledgeablePubsubMessage acknowledgeablePubsubMessage);

}
