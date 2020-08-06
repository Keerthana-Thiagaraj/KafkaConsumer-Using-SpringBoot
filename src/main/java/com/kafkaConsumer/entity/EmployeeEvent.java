package com.kafkaConsumer.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
public class EmployeeEvent {

    @Id
    @GeneratedValue
    public Integer empEventId;
    private String empEventName;

    @OneToOne(mappedBy = "employeeEvent", cascade = CascadeType.ALL)
    @ToString.Exclude
    private EmployeeModel employeeModel;

//    public Integer getEmpEventId() {
//        return empEventId;
//    }
}
