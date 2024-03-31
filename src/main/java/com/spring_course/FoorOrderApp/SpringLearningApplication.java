package com.spring_course.FoorOrderApp;

import com.spring_course.FoorOrderApp.DAO.DishesDAO;
import com.spring_course.FoorOrderApp.DAO.Dishes_DAO;
import com.spring_course.FoorOrderApp.Model.DishesEntity;
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
	public CommandLineRunner comandLineRunner(Dishes_DAO dishesDao){

		return runner->{
		System.out.println("commandliner-- :");
//			System.out.println(getDish(dishesDao,"m2"));
//			System.out.println(getAllDishes(dishesDao));

				System.out.println(dishesDao.getAlltables());

		};

	}
	public static String  getDish(Dishes_DAO dishesdao,String id){
		return dishesdao.getDish(id).toString();
	}
	public static List<DishesEntity> getAllDishes(Dishes_DAO dishesdao){
		return dishesdao.getAllDishes();
	}

}
