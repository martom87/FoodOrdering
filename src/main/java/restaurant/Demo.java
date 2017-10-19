package restaurant;

import helper.Helper;
import model.Course;
import model.Dessert;
import model.Order;
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
        manager.addDessertToMenu("ice cream", 8.75);
        manager.addDessertToMenu("apfelstrudel", 4.26);
        manager.addDrinkToMenu("coke", 2.26);
        manager.addDrinkToMenu("fanta", 0.46);
        manager.addDrinkToMenu("sprite", 0.56);
        manager.addDrinkToMenu("lemon", 0.26);
        manager.addDrinkToMenu("ice", 0.36);*/

        //  manager.removeFromMenuByName("pizza");


        //  waiter.presentCourses();
        // waiter.presentDesserts();
        //   waiter.presentDrinks();
        //  waiter.presentCousine();


        String name = null;
        double price = 0;
        Order order = new Order(name, price);

        List<Order> yourOrder = new ArrayList<Order>();


        boolean stillOrdering = false;
        System.out.println("Still ordering");
        Scanner sc = new Scanner(System.in);
        String orderStatus = sc.nextLine();
        if (orderStatus.equals("y")) {
            stillOrdering = true;
        }
        while (stillOrdering) {




            int casenumb = 2;
            switch (casenumb) {
                case 1:
                    casenumb = 1;
                    Course course = helper.selectCourseByName("bigos");
                    order.setName(course.getName());
                    order.setPrice(course.getPrice());
                    yourOrder.add(order);
                    System.out.println("You have ordered :" + "" + course);
                    break;

                case 2:
                    casenumb = 2;
                    Dessert dessert = helper.selectDessertByName("tiramisu");
                    order.setName(dessert.getName());
                    order.setPrice(dessert.getPrice());
                    yourOrder.add(order);
                    System.out.println("You have ordered :" + "" + dessert);
                    break;


            }
            break;
        }

        for (int i = 0; i < yourOrder.size(); i++) {
            System.out.println(order.getName());
        }

        helper.closeConnection();
    }
}



