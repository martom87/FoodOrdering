package model;

public class Order {
    int id;
    String name;
    double price;

    public Order(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {

        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        if (getPrice() == 0) {
            return "[" + id + "] - " + name + "  - " + "out of charge";
        } else {
            return "[" + id + "] - " + name + "  - " + price + " " + "PLN";
        }
    }
}
