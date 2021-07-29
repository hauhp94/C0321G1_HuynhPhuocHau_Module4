package com.example.blogapplicationextend.model.bean;

import com.example.blogapplicationextend.model.bean.Category;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Target;

@Entity
@Setter
@Getter
@Table(name = "blogs")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String blogName;
    private String content;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="category_id",referencedColumnName = "id")
    private Category category;
    @Column(name = "create_date", columnDefinition = "DATE")
    private String dateCreate;

    public Blog(String blogName, String content, Category category, String dateCreate) {
        this.blogName = blogName;
        this.content = content;
        this.category = category;
        this.dateCreate = dateCreate;
    }
}
