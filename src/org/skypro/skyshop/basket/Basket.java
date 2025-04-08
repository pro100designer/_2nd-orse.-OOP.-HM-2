package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Basket {
    private List<Product> products;
    private List<Product> productsRemoved;


    public Basket(LinkedList<Product> products) {
        this.products = products;

    }

    //1.Метод добавления товара
    public void addProduct(Product product) {
        products.add(product);
    }


    //2.Метод получения общей стоимости корзины
    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            if (products != null) {
                total += (int) product.getCost();
            }

        }
        return total;
    }

    //3.Метод, который печатает содержимое корзины
    public void printContentBasket() {
        int specialCount = 0;

        if (products.isEmpty()) {
            System.out.println(" В корзине пусто! ");
        } else {
            String listProduct = "";

            for (Product product : products) {
                if (product == null || product.getName().isEmpty()) {
                    continue;
                }
                System.out.println(product);
                if (listProduct.isEmpty()) {
                    listProduct = product.getName();
                } else {
                    listProduct += ", " + product.getName();
                }

                if (product.isSpecial()) {
                    specialCount++;
                }

            }
            System.out.println("Список продуктов: " + listProduct);
            System.out.println("Итого:" + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    //4.Метод, проверяющий продукт в корзине по имени
    public boolean checkProduct(String product) {
        for (Product p : products) {
            if (product != null && product.equals(p.getName())) {
                System.out.println("Товар " + product + " есть в наличии!");
                return true;
            }

        }
        System.out.println("Товар " + product + " отсутсвует!");
        return false;
    }

    //5.Метод очистки корзины
    public void cleanBasket() {
        products.clear();
        System.out.println("Корзина очищена!");
    }


    //6.Метод удаление продукта из списка по имени

    public List<Product> removeAllProduct(String name) {
        List<Product> removedProducts = new LinkedList<>();
        if (name == null) {
            System.out.println("Такого продукта нет в списке!");
            return removedProducts;
        }
        if (products.isEmpty()) {
            System.out.println("Список пуст!");
            return removedProducts;
        }
//        for (Product product:products) {
//            if (product.) {
//                System.out.println("Список пуст");
//            }
//        }
//        if (!removedProducts.contains(name)) {
//            System.out.println("Такого продукта нет в списке! ");
//        }
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (name.equals(product.getName())) {
                iterator.remove();
                removedProducts.add(product);
                System.out.println("Продукт " + name + " удален из корзины!");
            }

        }
        if (removedProducts.isEmpty()) {
            System.out.println("Продукт '" + name + "' не найден в списке!");
        }

        return removedProducts;
    }

    //7.Метод,которые печатает удаленный продукты
    public void printRemovedProduct(List<Product> list) {
        if (products.isEmpty()) {
            System.out.println("Список пуст! ");
            return;
        }
//        List<Product> removedProducts = new LinkedList<>();
        System.out.println("Были удалены следующие продукты:");
        for (Product product : list) {
            if (list.isEmpty()) {
                System.out.println("Продукт '" + product.getName() + "' не найден в списке!");
            } else {
                System.out.println("- " + product.getName() + " (Цена: " + product.getCost() + ")");
            }

        }

        System.out.println("Удалено товаров: " + list.size());
    }

}






