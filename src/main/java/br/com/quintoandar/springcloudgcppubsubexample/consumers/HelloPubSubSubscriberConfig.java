package br.com.quintoandar.springcloudgcppubsubexample.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class HelloPubSubSubscriberConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloPubSubSubscriberConfig.class);

    private final PubSubTemplate pubSubTemplate;

    private final HelloPubSubConsumer consumer;

    @Autowired
    public HelloPubSubSubscriberConfig(PubSubTemplate pubSubTemplate, HelloPubSubConsumer consumer) {
        this.pubSubTemplate = pubSubTemplate;
        this.consumer = consumer;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void subscribe() {
        LOGGER.info("Subscribing {} to {}", consumer.getClass().getSimpleName(), consumer.subscription());
        pubSubTemplate.subscribe(consumer.subscription(), consumer::consume);
    }

}
