package programming.practise.katas.katate_supermarket.engine;

import programming.practise.katas.katate_supermarket.discount.chain.DiscounterManager;
import programming.practise.katas.katate_supermarket.items.Product;

public class PriceCalculationEngine {

    private final DiscounterManager discounterManager;

    public PriceCalculationEngine() {
        discounterManager = new DiscounterManager();
    }

    public double calculatePrice(Product product) {
        return discounterManager.getDiscounter().calculatePrice(product);
    }
}
