package com.spring_course.FoorOrderApp.Model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;
@Data
@Entity
@Table(name = "Dishes")
public class DishesEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private String price;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
}
