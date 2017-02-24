package example.practise.katas.katate_supermarket.engine;

import example.practise.katas.katate_supermarket.items.Product;

public class PriceCalculationEngine {
    public double calculatePrice(Product product) {
        return product.getPrice() * product.getNumber();
    }
}
