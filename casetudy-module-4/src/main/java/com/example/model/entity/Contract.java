package com.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String contractStartDate;
    private String contractEndDate;
    private double contractDeposit;
    private double contractTotalMoney;
    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;
    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "service_id", referencedColumnName = "serviceId")
    private Service service;
    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetails;
    @Column(columnDefinition = "int default 0")
    private int isDelete;

}
