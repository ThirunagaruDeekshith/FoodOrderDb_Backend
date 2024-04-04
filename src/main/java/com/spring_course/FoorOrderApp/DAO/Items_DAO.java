package com.spring_course.FoorOrderApp.DAO;

import com.spring_course.FoorOrderApp.Model.ItemsEntity;

import java.util.List;

public interface Items_DAO {
    ItemsEntity getItem(String id);
    List<ItemsEntity> getAllItems();

}
