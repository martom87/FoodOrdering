package people;

import helper.Helper;

import java.util.Scanner;

public class Manager extends Waiter {



    public Manager(Helper helper) {
        super(helper);

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



    public void createExampleMenu() {
        Manager manager = new Manager(helper);
        helper.createAllTables();
        manager.addCourseToMenu("bigos", "Polish", 5.29);
        manager.addCourseToMenu("pizza", "Italian", 10.09);
        manager.addCourseToMenu("tortilla", "Mexican", 7.80);

        manager.addDessertToMenu("tiramisu", 9.99);
        manager.addDessertToMenu("ice cream", 8.75);
        manager.addDessertToMenu("pie", 5.26);

        manager.addDrinkToMenu("coke", 2.26);
        manager.addDrinkToMenu("fanta", 2.26);
        manager.addDrinkToMenu("sprite", 2.56);

        manager.addAdditionToMenu("lemon", 0.26);
        manager.addAdditionToMenu("ice", 0.16);
    }

    public void destroyExampleMenu() {
        helper.resetAllTables();

    }
}
