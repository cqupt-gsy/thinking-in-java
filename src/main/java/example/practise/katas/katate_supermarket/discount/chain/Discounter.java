package example.practise.katas.katate_supermarket.discount.chain;

import example.practise.katas.katate_supermarket.items.Product;

public interface Discounter {
    void setDiscounter(Discounter discounter);

    double calculatePrice(Product product);
}
