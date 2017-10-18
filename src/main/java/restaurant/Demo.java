package restaurant;

import helper.Helper;
import people.Manager;
import people.Waiter;

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
        //  waiter.presentDesserts();
        //  waiter.presentDrinks();
      //  waiter.presentCousine();
  System.out.println(helper.selectOrder("bigos").getName());
        helper.closeConnection();
    }


}
