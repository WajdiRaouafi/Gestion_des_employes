package com.sj.empmanagmentapplication;



public class Employee {

    private int id;
    private String name;
    private int  age;
    private String designation;
    private String departement;
    private double salary;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDesiganation() {
        return designation;
    }
    public void setDesiganation(String desiganation) {
        this.designation = desiganation;
    }
    public String getDepartment() {
        return departement;
    }
    public void setDepartment(String department) {
        this.departement = department;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", desiganation=" + designation
                + ", department=" + departement + ", salary=" + salary + "]";
    }
    public Employee(int id, String name, int age, String desiganation, String department, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.designation = desiganation;
        this.departement = department;
        this.salary = salary;
    }







}