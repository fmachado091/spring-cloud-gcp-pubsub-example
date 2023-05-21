package br.com.quintoandar.springcloudgcppubsubexample.publishers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
@Component
public class HelloPubSubPublisher extends PubSubPublisher {

    @Value("${gcp.topic.name}")
    private String topic;

    @Autowired
    public HelloPubSubPublisher(PubSubTemplate pubSubTemplate) {
        super(pubSubTemplate);
    }

    @Override
    protected String topic() {
        return topic;
    }

}
