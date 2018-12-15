package br.com.quintoandar.springcloudgcppubsubexample;

import com.google.pubsub.v1.PubsubMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HelloPubSubSubscriber {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloPubSubSubscriber.class);

    private static final String SUBSCRIPTION = "hello-pubsub-subscription";

    private final PubSubTemplate pubSubTemplate;

    @Autowired
    public HelloPubSubSubscriber(PubSubTemplate pubSubTemplate) {
        this.pubSubTemplate = pubSubTemplate;
    }

    private void consume(BasicAcknowledgeablePubsubMessage acknowledgeablePubsubMessage) {
        PubsubMessage message = acknowledgeablePubsubMessage.getPubsubMessage();
        LOGGER.info("message received: " + message.getData().toStringUtf8());
        acknowledgeablePubsubMessage.ack();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void subscribe() {
        pubSubTemplate.subscribe(SUBSCRIPTION, this::consume);
    }

}
