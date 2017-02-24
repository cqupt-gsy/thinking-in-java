package example.practise.katas.katate_supermarket.engine;

import example.practise.katas.katate_supermarket.discount.chain.DiscounterFactory;
import example.practise.katas.katate_supermarket.items.Product;

public class PriceCalculationEngine {

    private final DiscounterFactory discounterFactory;

    public PriceCalculationEngine() {
        discounterFactory = new DiscounterFactory();
    }

    public double calculatePrice(Product product) {
        return discounterFactory.getDiscounter().calculatePrice(product);
    }
}
