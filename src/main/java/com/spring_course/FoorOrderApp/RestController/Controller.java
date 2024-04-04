package com.spring_course.FoorOrderApp.RestController;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring_course.FoorOrderApp.Configurations.Id_genarator;
import com.spring_course.FoorOrderApp.DAO.CustomerDAO;
import com.spring_course.FoorOrderApp.DAO.Items_DAO;
import com.spring_course.FoorOrderApp.DAO.OrderItemsDAO;
import com.spring_course.FoorOrderApp.Model.Customer_details;
import com.spring_course.FoorOrderApp.Model.ItemsEntity;
import com.spring_course.FoorOrderApp.Model.Ordered_items;
import org.aspectj.lang.reflect.LockSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
public class Controller {

    private Map<String, Object> orderData;
    @Autowired
    private Items_DAO itemsDao;
    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private OrderItemsDAO orderItemsDAO;
    @CrossOrigin(origins = "*")
    @GetMapping("/items")
    JsonNode meals_request() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Iterable<ItemsEntity> dishesIterable = itemsDao.getAllItems();
        List<ItemsEntity> dishesList = new ArrayList<>();
        dishesIterable.forEach(dishesList::add);
        String dishes=objectMapper.writeValueAsString(dishesList);
        ObjectMapper objectMapper2 = new ObjectMapper();
        JsonNode jasonNode = null;
        try {
            jasonNode = objectMapper2.readTree(dishes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jasonNode;
    }

    @PostMapping("/orders")
    ResponseEntity<?> order_request(@RequestBody Map<String,Object> OrderData ){
        orderData = OrderData;
        if(orderData==null || orderData.get("order") == null){
            System.out.println("Bad request send");
            return new ResponseEntity<>("Order cannot be placed", HttpStatus.BAD_REQUEST);
        }
        Map<String,Object> order=(Map<String,Object>)orderData.get("order");
        Map<String,String> customer=(Map<String,String>)order.get("customer");
        if(customer==null ||
                customer.get("email") == null ||
                !customer.get("email").contains("@") ||
                customer.get("name") == null ||
                customer.get("name").trim() == "" ||
                customer.get("address").trim() == "" ||
                customer.get("postal-code") == null ||
                customer.get("postal-code").trim() == ""||
                customer.get("city") == null ||
                customer.get("city").trim() == ""

        ){
            System.out.println("Bad request send");
            return new ResponseEntity<>("Customer data not valid, So order cannot be placed", HttpStatus.BAD_REQUEST);
        }
        System.out.println(customer);
        System.out.println(OrderData);
        ObjectMapper objectMapper = new ObjectMapper();
        Id_genarator id_genarator=new Id_genarator();
        String customer_id= id_genarator.geneate_id(3);

        Customer_details customer_details=new Customer_details(
                customer_id,
                customer.get("name"),
                customer.get("email"),
                customer.get("address"),
                customer.get("postal-code"),
                customer.get("city"),
                customer.get("phone_number")

                );

        customerDAO.saveCustomer(customer_details);
        System.out.println("Customer Saved");
        List<Map<String,String>>Ordered_items_map= (List<Map<java.lang.String,java.lang.String>>)order.get("items");
        System.out.println(Ordered_items_map);
         for(Map<String,String> Ordered_item : Ordered_items_map){
            System.out.println(  String.valueOf(Ordered_item.get("quantity")));
            Ordered_items ordered_items=new Ordered_items(
                     id_genarator.geneate_id(3),
//                     "7S5",
                     Ordered_item.get("name"),
             Ordered_item.get("price"),
                     Ordered_item.get("description"),
                    Integer.parseInt(String.valueOf(Ordered_item.get("quantity"))),
                     customer_details
             );
             orderItemsDAO.saveOrderItem(ordered_items);

         }
        System.out.println("Order items Saved");
        // Define output JSON file
//        File outputFile = new File("./src/main/resources/static/orders.json");

//        try {
////            // Write OrderData map to JSON file
////            FileWriter fileWriter = new FileWriter(outputFile, true);
////            objectMapper.writeValue(outputFile, OrderData);
////            fileWriter.write("\n");
//
//
//            System.out.println("Order data successfully written to orders.json");
//        } catch (IOException e) {
//            System.err.println("Error writing order data to JSON file: " + e.getMessage());
//        }
        return new ResponseEntity<>("Order placed successfully", HttpStatus.OK);
    }



}
