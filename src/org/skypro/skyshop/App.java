package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.err.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.LinkedList;
import java.util.List;

public class App {
    private static final Product[] products = new Product[10];

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Basket basket = new Basket(new LinkedList<>());
        //1.Добавление продукта в корзину.
        System.out.println("1.Добавление продукта в корзину.");
        basket.products.add(new SimpleProduct("Мороженное", 95));
        basket.products.add(new SimpleProduct("Сок", 170));
        basket.products.add(new SimpleProduct("Стейк говядины", 679));
        basket.products.add(new SimpleProduct("Яйца", 120));
        basket.products.add(new SimpleProduct("Хлеб", 79));

        //2.Добавление продукта в заполненную корзину, в которой нет свободного места.
        System.out.println("2.Добавление продукта в заполненную корзину, в которой нет свободного места.");

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
        Product water = new SimpleProduct("Вода", 150);
        Product tShort = new DiscountedProduct("Кофта", 5000, 20);
        Product bananes = new FixPriceProduct("Бананы");
        products[5] = water;
        products[6] = tShort;
        products[7] = bananes;

        basket.printContentBasket();
        //12.Тестирование изменений. ООП полиморфизм
        System.out.println("12.Тестирование изменений. ООП полиморфизм");
        SearchEngine engine = new SearchEngine(10);

        engine.add(new Product("Телевизор"));
        engine.add(new Product("Ноутбук"));
        engine.add(new Product("Стиральная машина"));


        engine.add(new Article("Телевизор Samsung", "Разрешение 1920х1080 FullHD "));
        engine.add(new Article("Ноутбук macbook", "13.3 (2560x1600) IPS, 60 Гц"));
        engine.add(new Article("Стиральная машина LG", " снабжена интеллектуальной системой распознавания ткани"));


        Searchable[] result1 = engine.search("Телевизор");

        engine.excludeNull(result1);

        //13.Демонстрация проверки данных в классе main. Исключения
        System.out.println("13.Демонстрация проверки данных в классе main. Исключения");

        try {
            Product boots = new Product("");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            Product suit = new SimpleProduct("Костюм ", -120);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            Product dress = new DiscountedProduct("Платье", -120, 101);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        SearchEngine searchEngine = new SearchEngine(4);
        // 13.1 случай.
        searchEngine.add(new Product("Телевизор"));
        try {
            searchEngine.foundSuitableProductSearchBar("Телевизор");
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        // 13.2 случай.
        searchEngine.add(new Product("Вело с пд"));
        try {
            searchEngine.foundSuitableProductSearchBar("Велосипед");
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        //14.Демонстрация коллекций
        System.out.println("14.Демонстрация коллекций");
        basket.addProduct(new SimpleProduct("Стейк", 750));
        basket.addProduct(new SimpleProduct("Молоко", 80));
        basket.addProduct(new SimpleProduct("Мороженное", 125));

        //14.1. Удалить существующий продукт из корзины.
        System.out.println("14.1. Удалить существующий продукт из корзины.");
        List<Product> remove = basket.removeAllProduct("Стейк");
        //14.2. Вывести удаленные продукты на экран.
        System.out.println("14.2. Вывести удаленные продукты на экран.");
        basket.printRemovedProduct(remove);
        //14.3. Вывести содержимое корзины с помощью метода printBacket.
        System.out.println("14.3. Вывести содержимое корзины с помощью метода printBacket.");
        basket.printContentBasket();
        //14.4. Удалить несуществующий продукт.
        System.out.println("14.4. Удалить несуществующий продукт.");
        List<Product> remove1 = basket.removeAllProduct("Жвачка");
        //14.5. Проверить, что список удаленных продуктов пустой и вывести сообщение “Список пуст”.
        System.out.println("14.5. Проверить, что список удаленных продуктов пустой и вывести сообщение “Список пуст”.");
        List<Product> remove2 = basket.removeAllProduct("Стейк");



    }
}
