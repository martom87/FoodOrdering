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
        helper.createAllTables();

     /*   Manager manager = new Manager(helper);
        manager.destroyExampleMenu();
        manager.createExampleMenu();*/

        Waiter waiter = new Waiter(helper);
        waiter.makeAnOrder();

        helper.closeConnection();
    }
}



