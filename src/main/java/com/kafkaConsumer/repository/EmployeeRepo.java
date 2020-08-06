package com.kafkaConsumer.repository;

import com.kafkaConsumer.entity.EmployeeEvent;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<EmployeeEvent, Integer> {
}
