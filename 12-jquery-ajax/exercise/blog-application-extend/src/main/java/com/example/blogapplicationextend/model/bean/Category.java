package com.example.blogapplicationextend.model.bean;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "categorys")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String categoryName;
    @JsonIgnore
    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    private List<Blog> blogs;




}
