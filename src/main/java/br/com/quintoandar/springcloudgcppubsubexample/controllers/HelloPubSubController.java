package br.com.quintoandar.springcloudgcppubsubexample.controllers;

import br.com.quintoandar.springcloudgcppubsubexample.publishers.HelloPubSubPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloPubSubController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloPubSubController.class);

    private final HelloPubSubPublisher publisher;

    @Autowired
    public HelloPubSubController(HelloPubSubPublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/publish")
    public void publish(@RequestBody String message) {
        LOGGER.info("received a POST at /hello/publish with message=[{}]", message);
        publisher.publish(message);
    }

}
