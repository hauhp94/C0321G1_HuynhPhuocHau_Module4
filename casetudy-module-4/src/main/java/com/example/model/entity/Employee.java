package com.example.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String employeeName;
    private String employeeBirthday;
    private String employeeIdCard;
    private double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
    @ManyToOne(targetEntity = EducationDegree.class)
    @JoinColumn(name = "education_degree_id", referencedColumnName = "id")
    private EducationDegree educationDegree;
    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    private Division division;
    @ManyToOne(targetEntity = AppUser.class)
    @JoinColumn(name = "username", referencedColumnName = "id")
    private AppUser appUser;
    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;
    @Column(columnDefinition = "int default 0")
    private int isDelete;

    public Employee(int employeeId, String employeeName, String employeeBirthday,
                    String employeeIdCard, double employeeSalary, String employeePhone,
                    String employeeEmail, String employeeAddress, Position position,
                    EducationDegree educationDegree, Division division, AppUser appUser) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.appUser = appUser;
    }
}
