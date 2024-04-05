package com.spring_app.ShoppingAppAZ.DAO;

import com.spring_app.ShoppingAppAZ.Model.ItemsEntity;

import java.util.List;

public interface Items_DAO {
    ItemsEntity getItem(String id);
    List<ItemsEntity> getAllItems();

}
