package com.sj.empmanagmentapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;


public class EmployeeService {

    HashSet<Employee> empset=new HashSet<Employee>();

//    Employee emp1=new Employee(101, "Shital", 24, "Developer", "IT", 25000);
//    Employee emp2=new Employee(102, "Meena", 26, "Tester","CO", 57000);
//    Employee emp3=new Employee(103, "Bob", 20, "DevOps Eng","Admin", 5000);
//    Employee emp4=new Employee(104, "Max", 27, "System Eng","CO",  70000);

    Scanner sc=new Scanner(System.in);
    boolean found=false;
    int id;
    String name;
    int age;
    String departement;
    String designation;
    double salary;

    public EmployeeService() {

//        empset.add(emp1);
//        empset.add(emp2);
//        empset.add(emp3);
//        empset.add(emp4);

    }

    //view all employees
    public void viewAllEmps() {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String sql = "SELECT * FROM employee";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String designation = resultSet.getString("designation");
                String department = resultSet.getString("departement");
                double salary = resultSet.getDouble("salary");

                Employee emp = new Employee(id, name, age, designation, department, salary);
                System.out.println(emp);
            }

//            resultSet.close();
//            statement.close();
//            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //view emp based on their id
    public void viewEmp() {
        System.out.println("Enter id: ");
        int id = sc.nextInt();

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String sql = "SELECT * FROM employee WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String designation = resultSet.getString("designation");
                String department = resultSet.getString("departement");
                double salary = resultSet.getDouble("salary");

                Employee emp = new Employee(id, name, age, designation, department, salary);
                System.out.println(emp);
            } else {
                System.out.println("Employee with this id is not present");
            }

//            resultSet.close();
//            statement.close();
//            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //update the employee
    public void updateEmployee() {
        System.out.println("Enter id: ");
        id = sc.nextInt();
        boolean found = false;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String sql = "SELECT * FROM employee WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the parameter value for the id
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                found = true;
                System.out.println("Enter new name: ");
                name = sc.next();
                System.out.println("Enter new salary: ");
                salary = sc.nextDouble();

                // Update the employee record in the database
                sql = "UPDATE employee SET name = ?, salary = ? WHERE id = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, name);
                statement.setDouble(2, salary);
                statement.setInt(3, id);
                statement.executeUpdate();

                System.out.println("Employee details updated successfully!");
            }

//            resultSet.close();
//            statement.close();
//            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (!found) {
            System.out.println("Employee is not present");
        }
    }

    //delete emp
    public void deleteEmp() {
        System.out.println("Enter id");
        id = sc.nextInt();
        boolean found = false;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String sql = "DELETE FROM employee WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                found = true;
                System.out.println("Employee deleted successfully!!");
            } else {
                System.out.println("Employee is not present");
            }

//            statement.close();
//            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //add emp
    public void addEmp() {
        System.out.println("Enter id:");
        id=sc.nextInt();
        System.out.println("Enter name");
        name=sc.next();
        System.out.println("Enter age");
        age=sc.nextInt();
        System.out.println("enter Designation");
        designation=sc.next();
        System.out.println("Enter Department");
        departement=sc.next();
        System.out.println("Enter sal");
        salary = sc.nextDouble();
         try {
             Connection connection = DatabaseConnection.getInstance().getConnection();
            // String sql = "INSERT INTO employee (id,name,age, designation, departement,salary) VALUES (id,name,age,designation,departement,salary)";
             String sql = "INSERT INTO employee (id, name, age, designation, departement, salary) VALUES (?, ?, ?, ?, ?, ?)";
             PreparedStatement  statement = connection.prepareStatement(sql);
             // Set parameter values
             statement.setInt(1, id);
             statement.setString(2, name);
             statement.setInt(3, age);
             statement.setString(4, designation);
             statement.setString(5, departement);
             statement.setDouble(6, salary);

             // Execute the INSERT statement
             statement.executeUpdate();

             // Close the statement and connection
//             statement.close();
//             connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Employee addeed successsfully");

    }

}
