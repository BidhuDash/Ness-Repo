package com.NessSpring.NessSpring_ORM_Pract3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.NessSpring.NessSpring_ORM_Pract3.dao.EmployeeDao;
import com.NessSpring.NessSpring_ORM_Pract3.entities.EmployeeModel;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		EmployeeDao dao = context.getBean("employeeDao", EmployeeDao.class);

//        EmployeeModel emp = new EmployeeModel();
//        emp.setId(2);
//        emp.setName("Dash Bidhu");
//        emp.setEmail("DB@ness.com");

//        int result = dao.addEmployees(emp);
//        System.out.println("("+result+") rows Inserted... ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		@SuppressWarnings("unused")
		boolean flag = true;

		while (true) {
			System.out.println("#@#@#@#@#@#@#@#@#@##@#@#@#@#@#@#@#@#@##@#@");
			System.out.println("Press any numbers to get the transactions done below:-");
			System.out.println("	Press 1: To get all Employees from the table");
			System.out.println("	Press 2: To add an Employee");
			System.out.println("	Press 3: To delete an Employee");
			System.out.println("	Press 4: To update an Employee");
			System.out.println("	Press 5: To get employee by ID");
			System.out.println("	Press 6: To terminate");
			System.out.println("#@#@#@#@#@#@#@#@#@##@#@#@#@#@#@#@#@#@##@#@");

			try {
				int option = Integer.parseInt(br.readLine());

				switch (option) {
				case 1:
					// Get all employees
					List<EmployeeModel> emp = dao.getEmployees();
					for (EmployeeModel employeeModel : emp) {
						System.out.println(employeeModel);
					}
					break;
				case 2:
					// Save employee
					System.out.println("Enter the Employee id");
					int id2 = br.read();
					System.out.println("Enter the Employee name");
					String name2 = br.readLine();
					System.out.println("Enter the email");
					String email2 = br.readLine();

					EmployeeModel employeeModel2 = new EmployeeModel();
					employeeModel2.setId(id2);
					employeeModel2.setName(name2);
					employeeModel2.setEmail(email2);
					dao.addEmployees(employeeModel2);
					break;

				case 3:
					// delete an employee
					System.out.println("Enter the id to delete an employee");
					int id3 = br.read();
					EmployeeModel employeeModel3 = new EmployeeModel();
					employeeModel3.setId(id3);
					dao.deleteEmployee(employeeModel3);
					System.out.println("Employee id " + employeeModel3.getId() + " deleted Successfully ");
					break;

				case 4:
					// update an employee
					System.out.println("Enter the following to update an employee:");
					System.out.println("Enter the Employee id");
					int id4 = br.read();
					System.out.println("Enter the Employee name");
					String name4 = br.readLine();
					System.out.println("Enter the email");
					String email4 = br.readLine();
					EmployeeModel employeeModel4 = new EmployeeModel();
					employeeModel4.setId(id4);
					employeeModel4.setEmail(email4);
					employeeModel4.setName(name4);
					dao.updateEmployee(employeeModel4);
					System.out.println("Employee Updated successfully");
					break;

				case 5:
					// get employee by id
					System.out.println("Enter the Employee id to get info");
					int id5 = Integer.parseInt(br.readLine());
					EmployeeModel employeeModel5 = dao.getEmployeesById(id5);
					System.out.println(employeeModel5);
					break;

				case 6:
					// to terminate
					flag = false;
					System.out.println("Terminated successfully");
					return;

				default:
					System.out.println("choose option between 1-6");
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid Option");
			}

		}

	}// main
}// class
