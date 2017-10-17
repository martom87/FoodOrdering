package restaurant;

import java.util.List;

import helper.Helper;
import model.Course;
import people.Manager;
import people.Waiter;

public class Demo {

	public static void main(String[] args) {

		Helper helper = new Helper();
		Manager manager = new Manager(helper);
		Waiter waiter = new Waiter(helper);

		// manager.addCourses("pizza", "Italian", 10.09);
         //  manager.removeFromMenuByName("pizza");
		 waiter.presentMenu();

		helper.closeConnection();
	}

}
