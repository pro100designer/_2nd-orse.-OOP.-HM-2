package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    protected double basePrice;
    protected double sale;

    public DiscountedProduct(String title, double basePrice, double sale) {
        super(title);
        if ((basePrice <= 0) || (sale <= 0 || sale >= 100)) {
            throw new IllegalArgumentException("Базовая цена и скидка являются некорректными!");
        }
        this.basePrice = basePrice;
        this.sale = sale;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public double getCost() {
        basePrice = basePrice * (1 - (sale / 100));
        return basePrice;
    }

    @Override
    public String toString() {
        return "Имя продукта со скидкой " + getName() + ": " + " стоимость " + basePrice + " (" + sale + "%" + ") ";
    }
}
