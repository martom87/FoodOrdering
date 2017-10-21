package restaurant;

import helper.Helper;
import people.Waiter;

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



