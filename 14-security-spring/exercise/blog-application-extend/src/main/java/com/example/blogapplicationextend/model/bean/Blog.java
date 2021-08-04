package com.example.blogapplicationextend.model.bean;

import com.example.blogapplicationextend.model.bean.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Target;

@Entity
@Setter
@Getter
@Table(name = "blogs")
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

}
