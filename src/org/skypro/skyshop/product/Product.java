package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public class Product implements Searchable {
    private String name;


    public Product(String title) {
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
        return "Имя продукта " + name;
    }
}
