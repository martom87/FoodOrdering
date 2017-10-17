package helper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.Course;
import model.Dessert;

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
    //   createTables();
     //   resetTables();
    }

    public boolean createTables() {
        String createCourses = "CREATE TABLE IF NOT EXISTS courses (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255), cousine varchar(255), price double)";

        String createDesserts = "CREATE TABLE IF NOT EXISTS desserts (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255),price big_decimal)";

        try {
            stat.execute(createCourses);
            stat.execute(createDesserts);
        } catch (SQLException e) {
            System.err.println("Table Creation Error");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean resetTables() {
        String resetCourses = "DROP TABLE IF EXISTS COURSES";


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
            PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO courses values (NULL, ?, ?,?);");
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

    public boolean insertDessert(String name, BigDecimal price) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO desserts values (NULL, ?, ?);");
            prepStmt.setString(1, name);
            prepStmt.setBigDecimal(2, price);
        } catch (SQLException e) {
            System.err.println("Dessert insert Error");
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

    public List<Dessert>  selectDesserts() {
        List<Dessert>desserts = new LinkedList<Dessert>();
        try {
            ResultSet result = stat.executeQuery("SELECT* FROM desserts");
            int id;
            String name;
            BigDecimal price;
            while (result.next()){
                id = result.getInt("id");
                name = result.getString("name");
                price = result.getBigDecimal("price");
                desserts.add(new Dessert(id, name,price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return desserts;
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
