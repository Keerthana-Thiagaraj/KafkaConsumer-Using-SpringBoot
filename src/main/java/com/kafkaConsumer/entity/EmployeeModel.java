package com.kafkaConsumer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class EmployeeModel {

    @Id
    private Integer empId;

    private String empName;

    private String empGender;
    @OneToOne
    @JoinColumn(name = "empEventId")
    private EmployeeEvent employeeEvent;
}
