package com.spring_course.FoorOrderApp.DAO;

import com.spring_course.FoorOrderApp.Model.DishesEntity;

import java.util.List;

public interface Dishes_DAO {
    DishesEntity getDish(String id);
    List<DishesEntity> getAllDishes();
    List<DishesEntity>  getAlltables();
}
