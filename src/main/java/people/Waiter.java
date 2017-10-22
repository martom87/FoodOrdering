package people;

import java.text.DecimalFormat;
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

    public void makeAnOrder() {
        Waiter waiter = new Waiter(helper);
        Scanner sc = new Scanner(System.in);

        int stillOrdering = 1;
        while (stillOrdering == 1) {

            waiter.showPossibleOperations();
            Customer customer = new Customer(sc);
            int casenumb = customer.saySomething();
            try {
                switch (casenumb) {

                    case 1:
                        casenumb = 1;
                        System.out.println(" Please select number of course you would like to eat from the list below ");
                        waiter.presentCourses();
                        int idCourse = customer.saySomething();
                        Course course = helper.selectCourseById(idCourse);
                        helper.insertOrder(course.getName(), course.getPrice());
                        System.out.println("You have ordered :" + "" + course);
                        break;

                    case 2:
                        casenumb = 2;
                        System.out.println("Please select number of dessert you would like to eat from the list below");
                        waiter.presentDesserts();
                        int idDessert = customer.saySomething();
                        Dessert dessert = helper.selectDessertById(idDessert);
                        helper.insertOrder(dessert.getName(), dessert.getPrice());
                        System.out.println("You have ordered :" + "" + dessert);
                        break;

                    case 3:
                        casenumb = 3;
                        System.out.println("Please select number of drink you would like to eat from the list below");
                        waiter.presentDrinks();
                        int idDrink = customer.saySomething();
                        Drink drink = helper.selectDrinkById(idDrink);
                        helper.insertOrder(drink.getName(), drink.getPrice());
                        System.out.println("You have ordered :" + "" + drink);
                        // ice or lemon
                        System.out.println("------------------------------------------------------");
                        System.out.println("Would you like lemon or ice to your " + drink.getName());
                        System.out.println("------------------------------------------------------");
                        System.out.println("1" + "->" + "lemon please");
                        System.out.println("2" + "->" + "ice please");
                        System.out.println("3" + "->" + "lemon and ice");
                        System.out.println("4" + "->" + "No Thanks");

                        int wantIceOrLemon = customer.saySomething();
                        switch (wantIceOrLemon) {

                            case 1:
                                wantIceOrLemon = 1;
                                Addition addition = helper.selectAdditionById(1);
                                helper.insertOrder(addition.getName(), addition.getPrice());
                                System.out.println("You have ordered additional lemon to your " + "" + drink.getName());
                                break;
                            case 2:
                                wantIceOrLemon = 2;
                                addition = helper.selectAdditionById(2);
                                helper.insertOrder(addition.getName(), addition.getPrice());
                                System.out.println("You have ordered additional ice to your " + "" + drink.getName());
                                break;

                            case 3:
                                wantIceOrLemon = 3;
                                addition = helper.selectAdditionById(1);
                                helper.insertOrder(addition.getName(), addition.getPrice());
                                Addition addition2 = helper.selectAdditionById(2);
                                helper.insertOrder(addition2.getName(), addition2.getPrice());
                                System.out.println("You have ordered additional lemon and ice to your " + "" + drink.getName());
                                break;
                            case 4:
                                wantIceOrLemon = 4;
                                System.out.println("Your drink has no additions");
                                break;
                        }

                        break;

                    case 4:
                        casenumb = 4;
                        System.out.println("Please select your lunch set");
                        System.out.println("You can choose from our courses");
                        waiter.presentCourses();
                        int idCourse2 = customer.saySomething();
                        Course course2 = helper.selectCourseById(idCourse2);
                        helper.insertOrder(course2.getName(), course2.getPrice());
                        System.out.println("and our desserts");
                        System.out.println("in case of lunch set desserts are free");
                        waiter.presentDesserts2();
                        int idDessert2 = customer.saySomething();
                        Dessert dessert2 = helper.selectDessertById(idDessert2);
                        dessert2.setPrice(0.00);
                        helper.insertOrder(dessert2.getName(), dessert2.getPrice());
                        break;

                    case 5:

                        DecimalFormat df = new DecimalFormat("#.00");
                        stillOrdering = 2;
                        System.out.println("-----------------------");
                        waiter.presentOrder();
                        System.out.println("-----------------------");
                        System.out.println("-----------------------");
                        if (helper.calcBill() == 0) {
                            System.out.println("You haven't ordered anything");
                        } else {
                            System.out.println("Your Bill is" + " " + ":" + " " + df.format(helper.calcBill()) + " " + "PLN");
                        }
                        System.out.println("----------------------------");
                        System.out.println("Thank you very much indeed!");
                        System.out.println("Good Bye and See you Again!");
                        helper.resetOrdersTable();
                        sc.close();

                }
            } catch (NullPointerException ex) {
                System.out.println("THE MENU IS EMPTY !!! ");
                System.out.println("CALL THE MANAGER TO ADD ITEMS TO MENU!!!");
                break;
            }

        }
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

    public void presentDesserts2() {
        desserts = helper.selectDesserts();
        System.out.println("Desserts List: ");
        for (Dessert dessert : desserts) {
            System.out.println("[" + dessert.getId() + "]" + "-" + dessert.getName());
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
        System.out.println("What would you like to do now ?" + " " + "Please select the number from the list below:");
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("1" + " " + " " + "->" + "Order a main course");
        System.out.println("2" + " " + " " + "->" + "Order some dessert");
        System.out.println("3" + " " + " " + "->" + "Order something to drink");
        System.out.println("4" + " " + " " + "->" + "Order Lunch");
        System.out.println("5" + " " + " " + "->" + "Ask for a bill and leave the restaurant");
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
    }


}



