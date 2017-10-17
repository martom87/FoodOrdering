package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.Course;

public class Helper {
	private Connection conn;
	private Statement stat;

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:helper.db";
	final String ENABLE_FOREIGN_KEYS = "PRAGMA foreign_keys=ON";

	// db.execSQL(ENABLE_FOREIGN_KEYS);

	public Helper() {
		try {
			Class.forName(Helper.DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("NO JDBC DRIVER");
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(DB_URL);
			stat = conn.createStatement();
		} catch (SQLException e) {
			System.err.println("NO CONNECTION AVAILABLE");
			e.printStackTrace();
		}
		createTables();
	//	resetTables();
	}

	public boolean createTables() {
		String createCourses = "CREATE TABLE IF NOT EXISTS courses (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255), cousine varchar(255), price double)";
	

		try {
			stat.execute(createCourses);
		} catch (SQLException e) {
			System.err.println("Table Creation Error");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public boolean resetTables() {
		String resetCourses = "TRUNCATE TABLE courses";
	

		try {
			stat.execute(resetCourses);
		} catch (SQLException e) {
			System.err.println("Table Creation Error");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean insertCourse(String name, String cousine, double price) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO courses values (NULL, ?, ?, ?);");
			prepStmt.setString(1, name);
			prepStmt.setString(2, cousine);
			prepStmt.setDouble(3, price);
			prepStmt.execute();
		} catch (SQLException e) {
			System.err.println("Course insert Error");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void deleteCourseByName(String name) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM courses WHERE name = ?");
			prepStmt.setString(1, name);

			prepStmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Course insert Error");
			e.printStackTrace();
		
		}

	}
	
	public void deleteCourseById(int id) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM courses WHERE id = ?");
			//PreparedStatement prepStmt = conn.prepareStatement("TRUNCATE TABLE courses");
			prepStmt.setInt(1, id);
			

			prepStmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Course insert Error");
			e.printStackTrace();
		
		}

	}


	

	public List<Course> selectCourses() {
		List<Course> courses = new LinkedList<Course>();
		try {
			ResultSet result = stat.executeQuery("SELECT * FROM courses ");
			int id;
			String name;
			String cousine;
			double price;
			while (result.next()) {
				id = result.getInt("id");
				name = result.getString("name");
				cousine = result.getString("cousine");
				price = result.getDouble("price");
				courses.add(new Course(id, name, cousine, price));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}
		return courses;

	}
	
	
	


	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("Problem z zamknieciem polaczenia");
			e.printStackTrace();
		}
	}

}
