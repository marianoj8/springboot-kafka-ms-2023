package com.wasp.avt.stockservice.kafka;

import com.wasp.avt.basedomain.event.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class OrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent){
        LOGGER.info(String.format("Order event received in Stoke Service => %s", orderEvent.toString()));

        // save the order event into the database.
    }

}
