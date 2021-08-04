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
    public int service_id;
    public String service_code;
    public String service_name;
    public int service_area;
    public double service_cost;
    public int service_max_people;
    @ManyToOne(targetEntity = RentType.class)
    @JoinColumn(name = "rent_type_id", referencedColumnName = "id")
    public RentType rentType;
    @ManyToOne(targetEntity = ServiceType.class)
    @JoinColumn(name = "service_type_id", referencedColumnName = "id")
    public ServiceType serviceType;
    public String standard_room;
    public String description_other_convenience;
    public double pool_area;
    public int number_of_floors;
    public String free_service;
    @OneToMany(mappedBy = "service")
    private Set<Contract> contracts;
}
