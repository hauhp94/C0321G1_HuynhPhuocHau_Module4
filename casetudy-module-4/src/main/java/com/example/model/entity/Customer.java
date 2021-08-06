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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerCode;
    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;
    private String customerName;
    private String customerBirthday;
    private int customerGender;
    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;
    @Column(columnDefinition = "int default 0")
    private int serviceId;
    @Column(columnDefinition = "int default 0")
    private int contractDetailId;
    @Column(columnDefinition = "int default 0")
    private int quantity;
    @Column(columnDefinition = "int default 0")
    private int isDelete;
    @Column(columnDefinition = "int default 0")
    private int contractId;
    private String attachServiceName;


    public Customer(int customerId, String customerCode, CustomerType customerType,
                    String customerName, String customerBirthday, int customerGender,
                    String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }
}
