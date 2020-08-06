package com.kafkaConsumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkaConsumer.entity.EmployeeEvent;
import com.kafkaConsumer.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmpEventService {

    @Autowired
    ObjectMapper objectMapper; // retrieve object from json string

    @Autowired
    private EmployeeRepo employeeRepo;

    public void processEmpEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
        EmployeeEvent employeeEvent = objectMapper.readValue(consumerRecord.value(), EmployeeEvent.class); // value is where producer writes the event
        log.info("emp event" + employeeEvent);
        save(employeeEvent);
    }

    private void save(EmployeeEvent employeeEvent) {
        employeeEvent.getEmployeeModel().setEmployeeEvent(employeeEvent); // building the mapping.
        employeeRepo.save(employeeEvent);
        log.info("persisted" + employeeEvent);
    }

}
