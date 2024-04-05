package com.spring_app.ShoppingAppAZ.DAO;


import com.spring_app.ShoppingAppAZ.Model.Customer_details;
import com.spring_app.ShoppingAppAZ.Model.Ordered_items;

import java.util.List;

public interface OrderItemsDAO {

    List<Ordered_items> getAllOrders();
    List<Ordered_items> getOrdersbyOrderId(int id);
    void saveOrderItem(Ordered_items ordered_items);
}
