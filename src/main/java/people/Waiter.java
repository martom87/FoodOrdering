package people;

import java.security.Key;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import helper.Helper;
import model.Course;
import model.Dessert;
import model.Drink;
import model.Order;


public class Waiter {
    public Helper helper;
    public List<Course> courses;
    public List<Dessert> desserts;
    public List<Drink> drinks;
    public Map<String, Order> orders;

    public Waiter(Helper helper) {
        super();
        this.helper = helper;
    }

    public void presentCourses() {
        courses = helper.selectCourses();
        System.out.println("Courses List: ");
        for (Course course : courses) {
            System.out.println(course);
        }

    }

    public void presentCousine() {
        courses = helper.selectCourses();
        System.out.println("We serve dishes from following cousines:");
        for (Course course : courses) {
            System.out.println("*" + " " + course.getCousine());
        }
    }

    public void presentDesserts() {
        desserts = helper.selectDesserts();
        System.out.println("Desserts List: ");
        for (Dessert dessert : desserts) {
            System.out.println(dessert);
        }
    }

    public void presentDrinks() {
        drinks = helper.selectDrinks();
        System.out.println("Drinks List: ");
        for (Drink drink : drinks) {
            System.out.println(drink);
        }
    }

public void addToBill (){

}

}



