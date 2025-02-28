package org.skypro.skyshop;

import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.Product;

public class App {
    private static Product[] products = new Product[5];

    public static void main(String[] args) {
        System.out.println("Hello world!");
        products[0] = new Product("Мороженное", 95);
        products[1] = new Product("Сок", 170);
        products[2] = new Product("Стейк говяидны", 679);
        products[3] = new Product("Яйца", 120);
        products[4] = new Product("Хлеб", 79);
        Basket basket = new Basket();
        //1.Добавление продукта в корзину.
        System.out.println("1.Добавление продукта в корзину.");
        basket.addProduct(products[0]);
        //2.Добавление продукта в заполненную корзину, в которой нет свободного места.
        System.out.println("2.Добавление продукта в заполненную корзину, в которой нет свободного места.");
        basket.addProduct(products[1]);
        basket.addProduct(products[2]);
        basket.addProduct(products[3]);
        basket.addProduct(products[4]);
        basket.addProduct(products[2]);
        //3.Печать содержимого корзины с несколькими товарами.
        System.out.println("3.Печать содержимого корзины с несколькими товарами.");
        basket.printContentBasket();
        // 4.Получение стоимости корзины с несколькими товарами.
        System.out.println("4.Получение стоимости корзины с несколькими товарами.");
        System.out.println("Общая стоимость корзины равна " + basket.getTotalPrice());
        //5.Поиск товара, который есть в корзине.
        System.out.println("5.Поиск товара, который есть в корзине.");
        basket.checkProduct("Сок");
        //6.Поиск товара, которого нет в корзине.
        System.out.println("6.Поиск товара, которого нет в корзине.");
        basket.checkProduct("Торт");
        //7.Очистка корзины.
        System.out.println("7.Очистка корзины.");
        basket.cleanBasket();
        //8.Печать содержимого пустой корзины
        System.out.println("8.Печать содержимого пустой корзины");
        basket.printContentBasket();
        //9.Получение стоимости пустой корзины.
        System.out.println("9.Получение стоимости пустой корзины.");
        System.out.println("Общая стоимость корзины равна " + basket.getTotalPrice());
        //10.Поиск товара по имени в пустой корзине.
        System.out.println("10.Поиск товара по имени в пустой корзине.");
        basket.checkProduct("Яйца");


    }
}
