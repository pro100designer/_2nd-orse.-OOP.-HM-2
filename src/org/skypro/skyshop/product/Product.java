package org.skypro.skyshop.product;

public class Product {
    private String name;
    private int price;

    public Product(String title, int price) {
        this.name = title;
        this.price = price;
    }

    public String getName() {
        return name;
    }


    public int getCost() {
        return price;
    }

    public String toString() {
        return "Имя продукта " + name + ":" + "стоимость" + price + "рублей";
    }
}
