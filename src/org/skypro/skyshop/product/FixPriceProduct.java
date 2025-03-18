package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    private static final double FIX_PRICE_PRODUCT=200;

    public FixPriceProduct(String title) {
        super(title);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public double getCost() {
        return FIX_PRICE_PRODUCT;
    }
    @Override
    public String toString() {
        return "Имя продукта с фиксированной ценой " + getName() + ": " + " Фиксированная цена " + getCost();
    }
}
