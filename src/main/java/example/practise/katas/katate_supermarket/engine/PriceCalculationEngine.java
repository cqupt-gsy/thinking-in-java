package example.practise.katas.katate_supermarket.engine;

import example.practise.katas.katate_supermarket.discount.chain.DiscounterManager;
import example.practise.katas.katate_supermarket.items.Product;

public class PriceCalculationEngine {

    private final DiscounterManager discounterManager;

    public PriceCalculationEngine() {
        discounterManager = new DiscounterManager();
    }

    public double calculatePrice(Product product) {
        return discounterManager.getDiscounter().calculatePrice(product);
    }
}
