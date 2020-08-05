package com.kafkaConsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmpEventConsumer {

    @KafkaListener(topics = {"Employee-event"})
    public void OnMessage(ConsumerRecord<Integer, String> consumerRecord) {

        log.info("Consumer record"+ consumerRecord);

    }
}
