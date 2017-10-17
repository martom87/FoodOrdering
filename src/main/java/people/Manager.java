package people;

import helper.Helper;

public class Manager extends Waiter {

	public Manager(Helper helper) {
		super(helper);

	}

	public void addToMenu(String name, String cousine, double price) {
		helper.insertCourse(name, cousine, price);
	}
	
	public void removeFromMenuByName(String name) {
		helper.deleteCourseByName(name);
	}
}
