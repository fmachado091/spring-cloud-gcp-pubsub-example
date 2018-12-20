package br.com.quintoandar.springcloudgcppubsubexample.subscribers.config;

import br.com.quintoandar.springcloudgcppubsubexample.subscribers.consumers.HelloPubSubConsumer;
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

    private final HelloPubSubConsumer helloPubSubConsumer;

    @Autowired
    public HelloPubSubSubscriberConfig(PubSubTemplate pubSubTemplate, HelloPubSubConsumer helloPubSubConsumer) {
        this.pubSubTemplate = pubSubTemplate;
        this.helloPubSubConsumer = helloPubSubConsumer;
    }

    /**
     * It's called only when the application is ready to receive requests.
     * Passes a consumer implementation when subscribing to a Pub/Sub topic.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void subscribe() {
        LOGGER.info("Subscribing {} to {}", helloPubSubConsumer.getClass().getSimpleName(),
                helloPubSubConsumer.subscription());
        pubSubTemplate.subscribe(helloPubSubConsumer.subscription(), helloPubSubConsumer.consumer());
    }

}
