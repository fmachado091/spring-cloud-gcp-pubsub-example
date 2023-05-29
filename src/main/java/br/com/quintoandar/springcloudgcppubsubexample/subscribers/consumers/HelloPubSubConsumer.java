package br.com.quintoandar.springcloudgcppubsubexample.subscribers.consumers;

import com.google.pubsub.v1.PubsubMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
@Component
public class HelloPubSubConsumer extends PubSubConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloPubSubConsumer.class);

    @Value("${gcp.subscription.name}")
    private String subscription;

    @Override
    public String subscription() {
        return subscription;
    }

    @Override
    protected void consume(BasicAcknowledgeablePubsubMessage acknowledgeablePubsubMessage) {
        // extract wrapped message
        PubsubMessage message = acknowledgeablePubsubMessage.getPubsubMessage();

        // process message
        LOGGER.info("message received: " + message.getData().toStringUtf8());

        // acknowledge that message was received
        acknowledgeablePubsubMessage.ack();
    }

}
