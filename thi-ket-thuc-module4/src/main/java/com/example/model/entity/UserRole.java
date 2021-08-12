package com.example.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
//@Table(name = "User_Role", //
//        uniqueConstraints = { //
//                @UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "User_Id", "Role_Id" }) })
public class UserRole {

//    @Id
//    @GeneratedValue
//    @Column(name = "Id", nullable = false)
//    private Integer id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @PrimaryKeyJoinColumn
    @ManyToOne(targetEntity = AppUser.class)
    @JoinColumn(name = "username", referencedColumnName = "id")
    private AppUser appUser;


    @ManyToOne(targetEntity = AppRole.class)
    @JoinColumn(name = "Role_Id",referencedColumnName = "id")
    private AppRole appRole;
}
