package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public class Product implements Searchable  {
    private String name;


    public Product(String title) {
        if (title==null || title.isBlank()) {
            throw new IllegalArgumentException("Неверно введено название продукта!");

        }
        this.name = title;

    }

    public String getName() {
        return name;
    }



    public  double getCost(){
        return 1;
    }
    public  boolean isSpecial(){
        return false;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContent() {
        return "PRODUCT";
    }

    public String toString() {
        return "Название продукта " + name;
    }
}
