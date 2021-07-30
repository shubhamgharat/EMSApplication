package com.ems.view;

import java.util.List;
import java.util.Scanner;

import com.ems.dao.*;
import com.ems.model.Employee1;

public class EmpUI {

	public void ui() {
		Scanner sc=new Scanner(System.in);
		EmployeeDAO x=new EmployeeDAO();
		while(true) {
			System.out.println("-----MENU-----");
			System.out.println("1.New Employee");
			System.out.println("2.Edit Employee");
			System.out.println("3.Delete Employee");
			System.out.println("4.View All Employees");
			System.out.println("5.Exit");
			System.out.println("Enter your choice:");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter id:");
				int id=sc.nextInt();
				System.out.println("Enter name");
				String name=sc.next();
				System.out.println("Enter age:");
				int age=sc.nextInt();
				System.out.println("Enter city:");
				String city=sc.next();
				Employee1 e=new Employee1(id, name, age, city);
				
				x.newEmployee(e);
				break;
			case 2:
				System.out.println("Enter emp id to edit:");
				int eid=sc.nextInt();
				x.updateEmployee(eid);
				break;
			case 3:
				System.out.println("Enter emp if for deletion:");
				int eid1=sc.nextInt();
				x.deleteEmployee(eid1);
				break;
			case 4:
				List<Employee1> ls=x.getAllEmployees();
				System.out.println("Employee List:");
				for(Employee1 y:ls) {
					System.out.println(y);
				}
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
		}
	}
}
