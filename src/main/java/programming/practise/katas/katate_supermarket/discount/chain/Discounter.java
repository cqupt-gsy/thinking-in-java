package programming.practise.katas.katate_supermarket.discount.chain;

import programming.practise.katas.katate_supermarket.items.Product;

public interface Discounter {
    void setDiscounter(Discounter discounter);

    double calculatePrice(Product product);
}
