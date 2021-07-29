package com.example.blogapplicationextend.model.bean;


import com.example.blogapplicationextend.model.bean.Blog;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "categorys")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String categoryName;
    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    private List<Blog> blogs;

    public Category(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }


    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(Long id) {
        this.id = id;
    }
}
