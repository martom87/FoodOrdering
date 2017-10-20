package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.*;

public class Helper {
    private Connection conn;
    private Statement stat;

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:helper.db";


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
      //  createAllTables();
        //   resetAllTables();

    }
// Creating and reseting  tables

    public boolean createAllTables() {
        String createCourses = "CREATE TABLE IF NOT EXISTS courses (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255), cousine varchar(255), price double)";
        String createDesserts = "CREATE TABLE IF NOT EXISTS desserts (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255), price double)";
        String createDrinks = "CREATE TABLE IF NOT EXISTS drinks (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255), price double)";
        String createOrders = "CREATE TABLE IF NOT EXISTS orders (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255), price double)";
        String createAdditions = "CREATE TABLE IF NOT EXISTS additions (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255), price double)";
        try {
            stat.execute(createCourses);
            stat.execute(createDesserts);
            stat.execute(createDrinks);
            stat.execute(createOrders);
            stat.execute(createAdditions);
        } catch (SQLException e) {
            System.err.println("Table Creation Error");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean resetAllTables() {
        String resetCourses = "DROP TABLE IF EXISTS courses";
        String resetDesserts = "DROP TABLE IF EXISTS desserts";
        String resetDrinks = "DROP TABLE IF EXISTS drinks";
        String resetOrders = "DROP TABLE IF EXISTS orders";
        String resetAdditions = "DROP TABLE IF EXISTS additions";
        try {
            stat.execute(resetCourses);
            stat.execute(resetDesserts);
            stat.execute(resetDrinks);
            stat.execute(resetOrders);
            stat.execute(resetAdditions);
        } catch (SQLException e) {
            System.err.println("Table Creation Error");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean resetOrdersTable() {
        String resetOrders = "DROP TABLE IF EXISTS orders";
        try {
            stat.execute(resetOrders);
        } catch (SQLException e) {
            System.err.println("Table Creation Error");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Courses
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

    public Course selectCourseByName(String name) {
        Course course = null;
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM courses WHERE name = '" + name + "'");
            int id;
            String cousine;
            double price;
            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                cousine = result.getString("cousine");
                price = result.getDouble("price");
                course = new Course(id, name, cousine, price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return course;


    }

    public Course selectCourseById(int id) {
        Course course = null;
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM courses WHERE id = '" + id + "'");
            String name;
            String cousine;
            double price;
            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                cousine = result.getString("cousine");
                price = result.getDouble("price");
                course = new Course(id, name, cousine, price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return course;


    }
//Desserts

    public boolean insertDessert(String name, double price) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO desserts values (NULL, ?, ?);");
            prepStmt.setString(1, name);
            prepStmt.setDouble(2, price);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Dessert insert Error");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void deleteDessertByName(String name) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM desserts WHERE name = ?");
            prepStmt.setString(1, name);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Course insert Error");
            e.printStackTrace();

        }

    }

    public List<Dessert> selectDesserts() {
        List<Dessert> desserts = new LinkedList<Dessert>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM desserts ");
            int id;
            String name;
            double price;
            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                price = result.getDouble("price");
                desserts.add(new Dessert(id, name, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return desserts;

    }

    public Dessert selectDessertByName(String name) {
        Dessert dessert = null;
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM desserts WHERE name = '" + name + "'");
            int id;
            double price;
            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                price = result.getDouble("price");
                dessert = new Dessert(id, name, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dessert;
    }

    public Dessert selectDessertById(int id) {
        Dessert dessert = null;
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM desserts WHERE id = '" + id + "'");
            String name;
            double price;
            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                price = result.getDouble("price");
                dessert = new Dessert(id, name, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dessert;
    }


// Drinks

    public boolean insertDrink(String name, double price) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO drinks values (NULL, ?, ?);");
            prepStmt.setString(1, name);
            prepStmt.setDouble(2, price);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Dessert insert Error");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Drink> selectDrinks() {
        List<Drink> drinks = new LinkedList<Drink>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM drinks ");
            int id;
            String name;
            double price;
            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                price = result.getDouble("price");
                drinks.add(new Drink(id, name, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return drinks;

    }

    public Drink selectDrinkByName(String name) {
        Drink drink = null;
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM drinks WHERE name = '" + name + "'");
            int id;
            double price;
            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                price = result.getDouble("price");
                drink = new Drink(id, name, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return drink;
    }

    public Drink selectDrinkById(int id) {
        Drink drink = null;
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM drinks WHERE id = '" + id + "'");
            String name;
            double price;
            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                price = result.getDouble("price");
                drink = new Drink(id, name, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return drink;
    }

    public void deleteDrinks(String name) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM drinks WHERE name = ?");
            prepStmt.setString(1, name);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Drinks insert Error");
            e.printStackTrace();

        }
    }

    // Additions
    public boolean insertAddition(String name, double price) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO additions values (NULL, ?, ?);");
            prepStmt.setString(1, name);
            prepStmt.setDouble(2, price);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Addition insert Error");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Addition selectAdditionById(int id) {
        Addition addition = null;
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM additions WHERE id = '" + id + "'");
            String name;
            double price;
            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                price = result.getDouble("price");
                addition = new Addition(id, name, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return addition;
    }
    // Orders
    public boolean insertOrder(String name, double price) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO orders values (NULL, ?, ?);");
            prepStmt.setString(1, name);
            prepStmt.setDouble(2, price);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Order insert Error");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Order> selectOrders() {
        List<Order> orders = new LinkedList<Order>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM orders ");
            int id;
            String name;
            double price;
            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");

                price = result.getDouble("price");
                orders.add(new Order(id, name, price));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return orders;

    }

    public double calcBill() {
        double bill = 0.0;
        try {
            ResultSet result = stat.executeQuery("SELECT SUM (price) AS pay FROM orders ");
            while (result.next()) {
                bill = result.getDouble("pay");
                bill = Math.round(bill * 100);
                bill = bill / 100;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return bill;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Close Connection error");
            e.printStackTrace();
        }
    }

}
