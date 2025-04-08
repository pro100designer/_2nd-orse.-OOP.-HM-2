package org.skypro.skyshop.product;


public class SimpleProduct extends Product {
    protected double price;

    public SimpleProduct(String name,double price) {
        super(name);
        if (price<=0) {
            throw new IllegalArgumentException("Некорректно введена цена! ");

        }
        this.price = price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public double getCost() {
        return price;
    }

    @Override
    public String toString() {
        return "Название продукта " + getName()+ " цена: " + getCost();
    }
}
