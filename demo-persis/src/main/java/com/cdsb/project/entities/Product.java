package com.cdsb.project.entities;


public class Product {

    static private int countProducts = 0;

    private int id;
    public int getId() {
        return id;
    }

    private String name;
    private int prize;
    private int stock;

    public Product(int i, String name, int prize, int stock) {

        this.id = id;
        this.name = name;
        this.prize = prize;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", prize=" + prize + ", stock=" + stock + "]";
    }

}
