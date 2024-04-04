package com.spring_course.FoorOrderApp.DAO;

import com.spring_course.FoorOrderApp.Model.Customer_details;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerDAO_impl implements CustomerDAO{
    private EntityManager entityManager;
    @Autowired
    public CustomerDAO_impl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public List<Customer_details> getAllCustomers() {
        TypedQuery query =entityManager.createQuery("from Customer_details",Customer_details.class);
        return  query.getResultList();
    }

    @Override
    public Customer_details getCustomer_details(String id) {
        return entityManager.find(Customer_details.class,id);
    }
    @Transactional
    @Override
    public void saveCustomer(Customer_details customer_details) {
        entityManager.merge(customer_details);

    }
}
