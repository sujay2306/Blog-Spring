package com.springboot.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data                 //getters for all the fields
@AllArgsConstructor  //all args constructor
@NoArgsConstructor  //no args constructor
@Entity            //jpa annotation
@Table(name="posts",uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}) //making title as unique
public class Post {
    @Id             //primarykey
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="title", nullable = false)
    private  String title;

    @Column(name="description", nullable = false)
    private String description;
    @Column(name="content", nullable = false )
    private String content;
}
