package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;

public class Basket {
    Product[] products;
    int size;

    public Basket() {
        products = new Product[10];
        size = 0;

    }

    //1.Метод добавления товара
    public void addProduct(Product product) {
        if (products.length > size && product !=null) {
            products[size] = product;
            System.out.println("Продукт " + product.getName() + " добавлен в корзину! ");
            size++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }

    }

    //2.Метод получения общей стоимости корзины
    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < size; i++) {
           if (products[i]!=null){
               total += products[i].getCost();}

        }
        return total;
    }

    //3.Метод, который печатает содержимое корзины
    public void printContentBasket() {
        int specialCount=0;
        if (size == 0) {
            System.out.println(" В корзине пусто! ");
        } else  {
            for (Product product:products) {
                if (product!=null) {
                    System.out.println(product);
                    if (product.isSpecial()) {
                        specialCount++;
                    }
                }
            }
            System.out.println("Итого:" + getTotalPrice());
            System.out.println("Специальных товраров: " +specialCount);
        }
    }

    //4.Метод, проверяющий продукт в корзине по имени
    public boolean checkProduct(String product) {
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equals(product)) {
                System.out.println("Товар " + products[i].getName() + " есть в наличии!");
                return true;
            }

        }
        System.out.println("Товар " + product + " отсутсвует!");
        return false;
    }

    //5.Метод очистки корзины
    public void cleanBasket() {
        for (int i = 0; i < size; i++) {
            products[i] = null;
        }
        size = 0;
        System.out.println("Корзина пуста!");
    }
}






