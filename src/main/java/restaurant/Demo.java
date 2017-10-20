package restaurant;

import helper.Helper;
import model.Course;
import model.Dessert;
import model.Drink;
import model.Order;
import people.Customer;
import people.Manager;
import people.Waiter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Helper helper = new Helper();
        Manager manager = new Manager(helper);
        Waiter waiter = new Waiter(helper);


     /*   manager.addCourseToMenu("pizza", "Italian", 10.09);
        manager.addCourseToMenu("bigos", "Polish", 5.29);
        manager.addCourseToMenu("tortilla", "Mexican", 7.80);
        manager.addDessertToMenu("tiramisu", 9.99);
        manager.addDessertToMenu("ice cream", 8.75);1
        manager.addDessertToMenu("apfelstrudel", 4.26);
        manager.addDrinkToMenu("coke", 2.26);
        manager.addDrinkToMenu("fanta", 0.46);
        manager.addDrinkToMenu("sprite", 0.56);
        manager.addDrinkToMenu("lemon", 0.26);
        manager.addDrinkToMenu("ice", 0.36);*/

       // helper.insertAddition("lemon", 0.26);
       // helper.insertAddition("ice", 0.16);

       // manager.removeFromMenuByName("pizza");


     //     waiter.makeAnOrder();
        //manager.destroyExampleMenu();
      //  manager.createExampleMenu();
waiter.presentCourses();
        helper.closeConnection();
    }
}



