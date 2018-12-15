package br.com.quintoandar.springcloudgcppubsubexample.consumers;

import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;

import java.util.function.Consumer;

public abstract class PubSubConsumer {

    public abstract String subscription();

    protected abstract void consume(BasicAcknowledgeablePubsubMessage acknowledgeablePubsubMessage);

    public Consumer<BasicAcknowledgeablePubsubMessage> consumer() {
        return this::consume;
    }

}
