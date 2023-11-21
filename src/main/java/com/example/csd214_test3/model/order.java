package com.example.csd214_test3.model;

public class order {
    public int id;
    public String name;
    public String size;
    public int toppings;
    public double total;

    public order(int id, String name, String size, int toppings, double total) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.toppings = toppings;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getToppings() {
        return toppings;
    }

    public double getTotal() {
        return total;
    }
}
