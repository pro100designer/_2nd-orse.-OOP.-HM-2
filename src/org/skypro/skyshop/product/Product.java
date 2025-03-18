package org.skypro.skyshop.product;

public abstract class Product {
    private String name;


    public Product(String title) {
        this.name = title;

    }

    public String getName() {
        return name;
    }


    public abstract double getCost();
    public abstract boolean isSpecial();

    public String toString() {
        return "Имя продукта " + name;
    }
}
