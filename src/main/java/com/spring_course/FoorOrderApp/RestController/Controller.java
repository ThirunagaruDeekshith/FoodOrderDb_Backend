package com.spring_course.FoorOrderApp.RestController;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.spring_course.FoorOrderApp.DAO.DishesDAO;
import com.spring_course.FoorOrderApp.DAO.Dishes_DAO;
import com.spring_course.FoorOrderApp.Model.DishesEntity;
import org.springframework.asm.TypeReference;
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
    private Dishes_DAO dishesDao;

    @CrossOrigin(origins = "*")
    @GetMapping("/meals")
    JsonNode meals_request() throws IOException {
//        FileInputStream fi = new FileInputStream("D:\\spring-boot\\FoodOrderApp\\FoodOrderApp\\src\\main\\resources\\static\\available_indian_meals.json");
        ObjectMapper objectMapper = new ObjectMapper();

//        System.out.println(data);
        Iterable<DishesEntity> dishesIterable = dishesDao.getAllDishes();
        List<DishesEntity> dishesList = new ArrayList<>();
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
                customer.get("street").trim() == "" ||
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

        // Define output JSON file
        File outputFile = new File("./src/main/resources/static/orders.json");

        try {
            // Write OrderData map to JSON file
            FileWriter fileWriter = new FileWriter(outputFile, true);
            objectMapper.writeValue(outputFile, OrderData);
            fileWriter.write("\n");

            System.out.println("Order data successfully written to orders.json");
        } catch (IOException e) {
            System.err.println("Error writing order data to JSON file: " + e.getMessage());
        }
        return new ResponseEntity<>("Order placed successfully", HttpStatus.OK);
    }



}
