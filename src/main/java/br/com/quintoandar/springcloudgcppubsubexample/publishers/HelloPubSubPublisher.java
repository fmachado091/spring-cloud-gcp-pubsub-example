package br.com.quintoandar.springcloudgcppubsubexample.publishers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.stereotype.Component;

@Component
public class HelloPubSubPublisher extends PubSubPublisher {

    @Autowired
    public HelloPubSubPublisher(PubSubTemplate pubSubTemplate) {
        super(pubSubTemplate);
    }

    @Override
    protected String topic() {
        return "hello-pubsub";
    }

}
