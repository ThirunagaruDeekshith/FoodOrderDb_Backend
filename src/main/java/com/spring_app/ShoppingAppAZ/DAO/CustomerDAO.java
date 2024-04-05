package com.spring_app.ShoppingAppAZ.DAO;

import com.spring_app.ShoppingAppAZ.Model.Customer_details;

import java.util.List;

public interface CustomerDAO {

    List<Customer_details> getAllCustomers();
    Customer_details getCustomer_details(String id);
    void saveCustomer(Customer_details customer_details);

}
