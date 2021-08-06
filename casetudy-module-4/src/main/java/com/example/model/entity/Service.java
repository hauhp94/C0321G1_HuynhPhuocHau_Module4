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
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int serviceId;
    public String serviceCode;
    public String serviceName;
    public int serviceArea;
    public double serviceCost;
    public int serviceMaxPeople;
    @ManyToOne(targetEntity = RentType.class)
    @JoinColumn(name = "rent_type_id", referencedColumnName = "id")
    public RentType rentType;
    @ManyToOne(targetEntity = ServiceType.class)
    @JoinColumn(name = "service_type_id", referencedColumnName = "id")
    public ServiceType serviceType;
    public String standardRoom;
    public String descriptionOtherConvenience;
    public double poolArea;
    public int numberOfFloors;
    public String freeService;
    @OneToMany(mappedBy = "service")
    private Set<Contract> contracts;
    @Column(columnDefinition = "int default 0")
    private int isDelete;


    public Service(int serviceId, String serviceCode, String serviceName,
                   int serviceArea, double serviceCost, int serviceMaxPeople,
                   RentType rentType, ServiceType serviceType, String standardRoom,
                   String descriptionOtherConvenience, double poolArea, int numberOfFloors, String freeService) {
        this.serviceId = serviceId;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.freeService = freeService;
    }
}
