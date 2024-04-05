package com.spring_app.ShoppingAppAZ;

import com.spring_app.ShoppingAppAZ.DAO.CustomerDAO;
import com.spring_app.ShoppingAppAZ.DAO.Items_DAO;
import com.spring_app.ShoppingAppAZ.DAO.OrderItemsDAO;
import com.spring_app.ShoppingAppAZ.Model.Customer_details;
import com.spring_app.ShoppingAppAZ.Model.ItemsEntity;
import com.spring_app.ShoppingAppAZ.Model.Ordered_items;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringLearningApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringLearningApplication.class, args);
	}
	@Bean
	public CommandLineRunner comandLineRunner(Items_DAO items_DAO, CustomerDAO customerDAO, OrderItemsDAO orderItemsDAO){

		return runner->{
		System.out.println("commandliner-- :");
//			System.out.println(customerDAO.getAllCustomers());
//			System.out.println((customerDAO.getCustomer_details("1")));
//			System.out.println(orderItemsDAO.getOrdersbyOrderId(1));
//			saveCustomer(customerDAO);
//   saveOrderItems(orderItemsDAO);
		};

	}
	public static void saveCustomer(CustomerDAO customerDAO){
		Customer_details customer_details=new Customer_details(
				"4","vinay thuduri","vinay@gmail.com","Gachibowli","500032","Hyderabad","9908251246"
		);
		customerDAO.saveCustomer(customer_details);
		System.out.println("Saved");
	}

	public static  void saveOrderItems(OrderItemsDAO orderItemsDAO){


		Customer_details customer_details=new Customer_details(
				"4","vinay thuduri","vinay@gmail.com","Gachibowli","500032","Hyderabad","9908251246"
		);
		Ordered_items orderedItems=new Ordered_items("2","Denim Jacket","799.99","Classic denim jacket for men, perfect for casual wear. Made from high-quality denim fabric and featuring a button-up front and multiple pockets.",2,customer_details);

		orderItemsDAO.saveOrderItem(orderedItems);
		System.out.println("Saved");

	}

	public static String  getItem(Items_DAO ItemsDAO, String id){
		return ItemsDAO.getItem(id).toString();
	}
	public static List<ItemsEntity> getAllItems(Items_DAO itemsDao){
		return itemsDao.getAllItems();
	}

}
