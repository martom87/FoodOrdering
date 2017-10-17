package people;

import java.util.List;

import helper.Helper;
import model.Course;

public class Waiter {
Helper helper;

public Waiter(Helper helper) {
	super();
	this.helper = helper;
}

public void presentMenu(){
	List<Course>courses = helper.selectCourses();
    
	System.out.println("Courses List: ");
    for(Course course : courses)
        System.out.println(course);
}
}
