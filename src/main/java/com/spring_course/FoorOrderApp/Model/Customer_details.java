package com.spring_course.FoorOrderApp.Model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

//@Data
@Entity
@Table(name = "customer_details")
public class Customer_details {
    @Id
//   @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  String id;
    private String name;
    private String  email;


    private String address;

    private String postalcode;

    private String city;

    private  String phone_number;

    @OneToMany(mappedBy = "customer_details",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
//    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Ordered_items> Ordered_items;

    public Customer_details(String id,String name, String email, String address, String postalcode, String city,String phone_number) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.postalcode = postalcode;
        this.city = city;
        this.phone_number=phone_number;
    }

    public Customer_details(){}

    //    private List<Ordered_items> getOrdered_items(){
//        return Ordered_items;
//    }
//    public void setOrdered_items(List<Ordered_items> ordered_items){
//        this.Ordered_items=ordered_items;
//    }
    public String getOrdered_items(){
//
        for(Ordered_items ordered_items: Ordered_items){
            return ordered_items.toString();
        }
        return Ordered_items.toString();
    }

    @Override
    public String toString() {
        return "Customer_details{" +
                "id='" + id + '\'' +
                "name='"+name+'\''+
                ", email='" + email + '\'' +
                ", street='" + address + '\'' +
                ", postalcode='" + postalcode + '\'' +
                ", city='" + city + '\'' +
                ", orderedItems=" + (Ordered_items == null ? "null" : "[ ordered items]") +
                '}';
    }


}
