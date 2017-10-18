package people;

import helper.Helper;

public class Manager extends Waiter {

    Manager manager;
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






    public void removeFromMenuByName(String name) {
        helper.deleteCourseByName(name);
    }
}
