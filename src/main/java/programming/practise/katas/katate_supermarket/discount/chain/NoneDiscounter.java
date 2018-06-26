package programming.practise.katas.katate_supermarket.discount.chain;

import programming.practise.katas.katate_supermarket.items.Product;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class NoneDiscounter implements Discounter {

    private Discounter discounter;

    @Override
    public double calculatePrice(Product product) {
        if (isBlank(product.getDiscountRule())) {
            return product.getNumber() * product.getPrice();
        }
        return discounter.calculatePrice(product);
    }

    @Override
    public void setDiscounter(Discounter discounter) {
        this.discounter = discounter;
    }
}
