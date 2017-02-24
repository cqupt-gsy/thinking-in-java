package example.practise.katas.katate_supermarket.discount.chain;

import example.practise.katas.katate_supermarket.discount.chain.exception.NoSuchRuleException;
import example.practise.katas.katate_supermarket.items.Product;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuyXForYDiscounter implements Discounter {

    private final Pattern pattern;
    private Discounter discounter;

    public BuyXForYDiscounter(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public double calculatePrice(Product product) {
        final Matcher matcher = pattern.matcher(product.getDiscountRule());
        if (matcher.matches()) {
            int minNumber = Integer.parseInt(matcher.group(1));
            double discounterNumber = Double.parseDouble(matcher.group(2));
            int discounterTimes = (int) (product.getNumber() / minNumber);
            int restNumber = (int) (product.getNumber() % minNumber);
            return discounterNumber * discounterTimes + restNumber * product.getPrice();
        }
        if (discounter != null) {
            return discounter.calculatePrice(product);
        }
        throw new NoSuchRuleException();
    }

    @Override
    public void setDiscounter(Discounter discounter) {
        this.discounter = discounter;
    }
}
