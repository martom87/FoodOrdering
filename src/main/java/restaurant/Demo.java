package restaurant;

import helper.Helper;
import people.Customer;
import people.Manager;
import people.Waiter;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        System.out.println("Welcome to our Restaurant");
        System.out.println("Choose the person");
        System.out.println("1 -> Customer");
        System.out.println("2 -> Manager");

        Scanner sc = new Scanner(System.in);
        Helper helper = new Helper();
        helper.createAllTables();
        Customer customer = new Customer(sc);

        int personChoice = customer.saySomething();


        switch (personChoice) {

            case 1:
                personChoice = 1;
                Waiter waiter = new Waiter(helper);
                waiter.makeAnOrder();
                break;
            case 2:
                System.out.println("As a Manager you can:");
                System.out.println("1 -> Erase All Menu Items");
                System.out.println("2 -> Automatically Create an Example Menu");
                System.out.println("3 -> Add a new Menu Item Manually");
                System.out.println("4 -> Logout");
                Manager manager = new Manager(helper);
                int managerActivity = customer.saySomething();

                switch (managerActivity) {
                    case 1:
                        managerActivity = 1;
                        manager.destroyExampleMenu();
                        break;
                    case 2:
                        managerActivity = 2;
                        manager.createExampleMenu();
                        break;

                    case 3:
                        managerActivity = 3;

                        manager.addToMenuManuallty();
                        System.out.println("Good Bye");
                        break;

                    case 4:
                        managerActivity = 4;
                        break;
                }

            break;

        }
        helper.closeConnection();

    }
}




