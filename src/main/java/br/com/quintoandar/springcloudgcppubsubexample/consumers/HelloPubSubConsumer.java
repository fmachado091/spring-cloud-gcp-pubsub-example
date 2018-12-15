package br.com.quintoandar.springcloudgcppubsubexample.consumers;

import com.google.pubsub.v1.PubsubMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;
import org.springframework.stereotype.Service;

@Service
public class HelloPubSubConsumer extends PubSubConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloPubSubConsumer.class);

    @Override
    public String subscription() {
        return "hello-pubsub-subscription";
    }

    @Override
    protected void consume(BasicAcknowledgeablePubsubMessage acknowledgeablePubsubMessage) {
        PubsubMessage message = acknowledgeablePubsubMessage.getPubsubMessage();
        LOGGER.info("message received: " + message.getData().toStringUtf8());
        acknowledgeablePubsubMessage.ack();
    }

}
