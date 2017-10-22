package people;

import helper.Helper;
import model.Course;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Manager extends Waiter {
    Scanner sc = new Scanner(System.in);
    Customer customer = new Customer(sc);

    public Manager(Helper helper) {
        super(helper);

    }

    public void createExampleMenu() {
        Manager manager = new Manager(helper);
        helper.createAllTables();
        // adds main courses
        manager.addCourseToMenu("bigos", "Polish", 5.29);
        manager.addCourseToMenu("pizza", "Italian", 10.09);
        manager.addCourseToMenu("tortilla", "Mexican", 7.82);
        // adds desserts
        manager.addDessertToMenu("tiramisu", 9.99);
        manager.addDessertToMenu("ice cream", 8.75);
        manager.addDessertToMenu("pie", 5.26);
        // adds drinks
        manager.addDrinkToMenu("coke", 2.26);
        manager.addDrinkToMenu("fanta", 2.26);
        manager.addDrinkToMenu("sprite", 2.56);
        // adds additions
        manager.addAdditionToMenu("lemon", 0.26);
        manager.addAdditionToMenu("ice", 0.16);

        System.out.println("An Example Menu was generated");
    }

    public void addToMenuManuallty() {

        int finishAdding = 1;

        whatToAddToMenu();


        Scanner menuInLines = new Scanner(System.in);
        Scanner menuInPrice = new Scanner(System.in);

        while (finishAdding == 1) {
            whatToAddToMenu();
            int whatToAdd = customer.saySomething();
            switch (whatToAdd) {
                case 1:
                    System.out.println("Add Course name");
                    String courseName = menuInLines.nextLine();
                    System.out.println("Add Course cousine");
                    String cousineName = menuInLines.nextLine();
                    System.out.println("Add Course price");
                    double coursePrice = setPriceManually();
                    addCourseToMenu(courseName, cousineName, coursePrice);
                    break;
                case 2:
                    whatToAdd = 2;
                    System.out.println("Add Dessert name");
                    String DessertName = menuInLines.nextLine();
                    System.out.println("Add Dessert price");
                    double DessertPrice = setPriceManually();
                    addDessertToMenu(DessertName, DessertPrice);
                    break;
                case 3:
                    whatToAdd = 3;
                    System.out.println("Add Drink name");
                    String Drinkname = menuInLines.nextLine();
                    System.out.println("Add Drink price");
                    double DrinkPrice = setPriceManually();
                    addDrinkToMenu(Drinkname, DrinkPrice);
                    break;
                case 4:
                    whatToAdd = 4;
                    System.out.println("Add Addition name");
                    String additionName = menuInLines.nextLine();
                    System.out.println("Add Addition price");
                    double additionPrice = setPriceManually();
                    addAdditionToMenu(additionName, additionPrice);
                    break;
                case 5:
                    whatToAdd = 5;
                    menuInLines.close();
                    menuInPrice.close();
                    sc.close();
                    finishAdding = 2;


            }

        }


    }


    public void whatToAddToMenu() {
        System.out.println("-------------------------------------------------------------------");
        System.out.println();
        System.out.println("What would you like to Add now ?" + " " + "Please select the number from the list below:");
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("1" + " " + " " + "->" + "Add a main course");
        System.out.println("2" + " " + " " + "->" + "Add some dessert");
        System.out.println("3" + " " + " " + "->" + "Add something to drink");
        System.out.println("4" + " " + " " + "->" + "Add some addition for drinks");
        System.out.println("5" + " " + " " + "->" + "Finnish  Adding and leave the restaurant");
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
    }

    public void addCourseToMenu(String name, String cousine, double price) {
        helper.insertCourse(name, cousine, price);
    }

    public void addDessertToMenu(String name, double price) {
        helper.insertDessert(name, price);
    }

    public void addDrinkToMenu(String name, double price) {
        helper.insertDrink(name, price);
    }

    public void addAdditionToMenu(String name, double price) {
        helper.insertAddition(name, price);
    }

    public void removeCourseByName(String name) {
        helper.deleteCourseByName(name);
    }


    public void destroyExampleMenu() {
        helper.resetAllTables();
        System.out.println("The Menu is Empty Now");
    }

    public double setPriceManually() {
        double price = 0;
        boolean inputError = true;
        while (inputError) {
            Scanner menuInPrice = new Scanner(System.in);
            if (menuInPrice.hasNextDouble()) {
                inputError = false;
            }
            try {
                price = menuInPrice.nextDouble();

            } catch (InputMismatchException e) {
                System.out.println("Price must be a number !");
                System.out.println("Try to change use . or , signs, depending on your system settings");
            }
        }
        return price;

    }

}
