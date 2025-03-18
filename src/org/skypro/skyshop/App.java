package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    private static Product[] products = new Product[10];

    public static void main(String[] args) {
        System.out.println("Hello world!");
        products[0] = new SimpleProduct("Мороженное", 95);
        products[1] = new SimpleProduct("Сок", 170);
        products[2] = new SimpleProduct("Стейк говядины", 679);
        products[3] = new SimpleProduct("Яйца", 120);
        products[4] = new SimpleProduct("Хлеб", 79);
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
        //11.Проверка изменений. ООП наследование
        System.out.println("11.Проверка изменений. ООП наследование");
        Product water = new SimpleProduct("Вода",150);
        Product tShort = new DiscountedProduct("Кофта", 5000,20);
        Product bananes = new FixPriceProduct("Бананы");
        products[5]=  water;
        products[6]=  tShort;
        products[7]=  bananes;
        basket.addProduct(products[5]);
        basket.addProduct(products[6]);
        basket.addProduct(products[7]);
        basket.printContentBasket();
        //12.Тестирование изменений. ООП полиморфизм
        System.out.println("12.Тестирование изменений. ООП полиморфизм");
        SearchEngine engine=new SearchEngine(10);

        engine.add(new Product("Телевизор"));
        engine.add(new Product("Ноутбук"));
        engine.add(new Product("Стиральная машина"));


        engine.add(new Article("Телевизор Samsung","Разрешение 1920х1080 FullHD "));
        engine.add(new Article("Ноутбук macbook","13.3 (2560x1600) IPS, 60 Гц"));
        engine.add(new Article("Стиральная машина LG"," снабжена интеллектуальной системой распознавания ткани"));


        Searchable[] result1=engine.search("Телевизор");

        System.out.println(Arrays.toString(result1));


    }
}
