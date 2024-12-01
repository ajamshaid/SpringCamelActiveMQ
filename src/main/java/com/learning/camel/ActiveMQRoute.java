package com.learning.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Route to consume messages from ActiveMQ
        from("activemq:queue:ReqQue")
                .log("Received message: ${body}")
                .process(exchange -> {
                    // Process the message here
                    String message = exchange.getIn().getBody(String.class);
                    System.out.println("Processing message: " + message);
                });

//        // Route to send messages to ActiveMQ
//        from("direct:sendToQueue")
//                .to("activemq:queue:testQueue");
    }
}

