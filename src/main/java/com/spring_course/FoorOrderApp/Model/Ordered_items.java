package com.spring_course.FoorOrderApp.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "ordered_items")
public class Ordered_items {

    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  String id;

    private  String name;

    private  String price;

    private  String description;

    private  int quantity;
        @ManyToOne
    @JoinColumn(name = "order_id")
    private Customer_details customer_details;

    public Ordered_items( String id,String name, String price, String description, int quantity, Customer_details customer_details) {
       this.id=id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.customer_details = customer_details;
    }

    public Ordered_items(){}
}
