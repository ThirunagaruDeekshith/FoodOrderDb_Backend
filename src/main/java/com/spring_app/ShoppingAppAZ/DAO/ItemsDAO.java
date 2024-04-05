package com.spring_app.ShoppingAppAZ.DAO;

import com.spring_app.ShoppingAppAZ.Model.ItemsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ItemsDAO implements Items_DAO {
    private EntityManager entityManager;
    @Autowired
    public void Items_DAO(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public ItemsEntity getItem(String id){
        return entityManager.find(ItemsEntity.class,id);
    }
    @Override
    public List<ItemsEntity> getAllItems(){
        TypedQuery<ItemsEntity> query=entityManager.createQuery("FROM ItemsEntity", ItemsEntity.class);

        return query.getResultList();
    }
}
