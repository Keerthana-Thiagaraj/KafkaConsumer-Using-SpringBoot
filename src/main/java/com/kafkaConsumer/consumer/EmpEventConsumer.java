package com.kafkaConsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafkaConsumer.service.EmpEventService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmpEventConsumer {

    @Autowired
    EmpEventService empEventService;

    @KafkaListener(topics = {"Employee-event"})
    public void OnMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {

        log.info("Consumer record" + consumerRecord);
        empEventService.processEmpEvent(consumerRecord);

    }
}
