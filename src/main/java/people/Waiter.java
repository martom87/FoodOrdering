package people;

import java.util.List;
import java.util.Scanner;

import helper.Helper;
import model.*;


public class Waiter {
    public Helper helper;
    public List<Course> courses;
    public List<Dessert> desserts;
    public List<Drink> drinks;
    public List<Order> orders;

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

    public void presentOrder() {
        orders = helper.selectOrders();
        System.out.println("You have Ordered" + ":");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void showPossibleOperations() {
        System.out.println("-------------------------------------------------------------------");
        System.out.println();
        System.out.println("Would you like to do ?" + " " + "Please select the number from the list below:");
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("1" + " " + " " + "->" + "Order a main course");
        System.out.println("2" + " " + " " + "->" + "Order some dessert");
        System.out.println("3" + " " + " " + "->" + "Order something to drink");
        System.out.println("4" + " " + " " + "->" + "Ask for a bill and leave the restaurant");
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
    }


    public void makeAnOrder() {
        Waiter waiter = new Waiter(helper);
        Scanner sc = new Scanner(System.in);

        int stillOrdering = 1;
        while (stillOrdering == 1) {

            waiter.showPossibleOperations();
            Customer customer = new Customer(sc);
            int casenumb = customer.doSomething();
            switch (casenumb) {

                case 1:
                    casenumb = 1;
                    System.out.println(" Please select number of course you would like to eat from the list below ");
                    waiter.presentCourses();
                    int idCourse = sc.nextInt();
                    Course course = helper.selectCourseById(idCourse);
                    helper.insertOrder(course.getName(), course.getPrice());
                    System.out.println("You have ordered :" + "" + course);
                    break;

                case 2:
                    casenumb = 2;
                    System.out.println("Please select number of dessert you would like to eat from the list below");
                    waiter.presentDesserts();
                    int idDessert = sc.nextInt();
                    Dessert dessert = helper.selectDessertById(idDessert);
                    helper.insertOrder(dessert.getName(), dessert.getPrice());
                    System.out.println("You have ordered :" + "" + dessert);
                    break;

                case 3:
                    casenumb = 3;
                    System.out.println("Please select number of drink you would like to eat from the list below");
                    waiter.presentDrinks();
                    int idDrink = sc.nextInt();
                    Drink drink = helper.selectDrinkById(idDrink);
                    helper.insertOrder(drink.getName(), drink.getPrice());
                    System.out.println("You have ordered :" + "" + drink);
                    // ice or lemon
                    System.out.println("Would you like lemon or ice to your " + drink.getName());

                    int wantIceorLemon = sc.nextInt();
                    switch (wantIceorLemon) {

                        case 1:
                            wantIceorLemon = 1;
                            Addition addition = helper.selectAdditionById(1);
                            helper.insertOrder(addition.getName(), addition.getPrice());
                            System.out.println("You have ordered additional lemon to your " + "" + drink.getName());
                            break;
                        case 2:
                            wantIceorLemon = 2;
                            addition = helper.selectAdditionById(2);
                            helper.insertOrder(addition.getName(), addition.getPrice());
                            System.out.println("You have ordered additional ice to your " + "" + drink.getName());
                            break;
                        case 3:
                            wantIceorLemon = 3;
                            System.out.println("Your drink has no additions");
                            break;
                    }

                    break;

                case 4:
                    casenumb = 4;
                    stillOrdering = 2;
                    waiter.presentOrder();
                    System.out.println("-----------------------");
                    System.out.println("-----------------------");
                    System.out.println("Your Bill is" + ":" + helper.calcBill() + " " + "PLN");
                    helper.resetOrdersTable();
                    sc.close();


            }

        }
    }
}



