package com.spring_course.FoorOrderApp.DAO;

import com.spring_course.FoorOrderApp.Model.Customer_details;
import com.spring_course.FoorOrderApp.Model.Ordered_items;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemsDAO_impl implements OrderItemsDAO{

    private EntityManager entityManager;
    @Autowired
    public OrderItemsDAO_impl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public List<Ordered_items> getAllOrders() {
        TypedQuery query =entityManager.createQuery("from Ordered_items",Ordered_items.class);
        return  query.getResultList();
    }

    @Override
    public List<Ordered_items> getOrdersbyOrderId(int id) {
        TypedQuery query =entityManager.createQuery("from Ordered_items where customer_details.id=:data",Ordered_items.class);
        query.setParameter("data",id);
        return  query.getResultList();
    }
    @Transactional
    @Override
    public void saveOrderItem(Ordered_items ordered_items) {
        entityManager.merge(ordered_items);

    }

}
