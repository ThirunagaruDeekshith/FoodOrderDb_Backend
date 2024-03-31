package com.spring_course.FoorOrderApp.DAO;

import com.spring_course.FoorOrderApp.Model.DishesEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DishesDAO implements Dishes_DAO{
    private EntityManager entityManager;
    @Autowired
    public void DishesDAO(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public DishesEntity getDish(String id){
        return entityManager.find(DishesEntity.class,id);
    }
    @Override
    public List<DishesEntity> getAllDishes(){
        TypedQuery<DishesEntity> query=entityManager.createQuery("FROM DishesEntity",DishesEntity.class);

        return query.getResultList();
    }
    public List<DishesEntity>  getAlltables(){
        Query query =entityManager.createNativeQuery("select * from dishes");
        return query.getResultList();
    }
}
