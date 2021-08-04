package com.example.blogapplicationextend.model.bean;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "categorys")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String categoryName;

    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    private List<Blog> blogs;




}
