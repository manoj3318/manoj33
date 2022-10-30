package com.gavs.springboot;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gavs.springboot.model.Employee;
import com.gavs.springboot.model.SpringDAO;

@SpringBootApplication
public class MainApp {
	public static void main(String args[]) throws Exception {
		SpringApplication.run(MainApp.class,args);
		System.out.println("Application running Successfully");
		
		//int option=0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 1 for insert\n Enter 2 for display\n Enter 3 for update\n Enter 4 for delete");
		int option =scan.nextInt();
		MainApp mainapp = new MainApp();
		Employee employ = new Employee();
		SpringDAO springdao = new SpringDAO();
		
		if(option == 1) {
			System.out.println("Enter the Employee id");
			int id = scan.nextInt();
			
			System.out.println("Enter the Employee name");
			String name =scan.next();
			employ.setId(id);
			employ.setName(name);
		springdao.addEmployee(employ);
		}
		if(option ==2) {
			//System.out.println("Display the Emp details");
			//String display =scan.next();
			springdao.fetchEmployee(employ);
			System.out.println(employ.getId() +" "+ employ.getName());
		
		}
		if(option == 3) {
			
			System.out.println("Enter the name to update");
			String name = scan.next();
			System.out.println("Enter the id ");
			int id = scan.nextInt();
			
			employ.setName(name);
			employ.setId(id);
		springdao.modifyEmployee(employ);
		System.out.println("Succesfully updated...");
		}
		if(option==4) {
			System.out.println("Enter the id to delete");
			int id= scan.nextInt();
			//System.out.println("Enter the name to delete");
			//String name=scan.next();
			employ.setId(id);
		springdao.deleteEmployee(employ);
	System.out.println("Successfully deleted");
		//employ.setName(name);
		}
		
	}
	
}
