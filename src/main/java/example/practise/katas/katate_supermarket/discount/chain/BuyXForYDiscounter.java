package example.practise.katas.katate_supermarket.discount.chain;

import example.practise.katas.katate_supermarket.items.Product;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static example.practise.katas.katate_supermarket.discount.chain.DiscounterRulePattern.BUY_X_FOR_Y_PATTERN;

public class BuyXForYDiscounter implements Discounter {

    private final Pattern pattern = Pattern.compile(BUY_X_FOR_Y_PATTERN);
    private Discounter discounter;


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
        throw new RuntimeException("No such discounter rule");
    }

    @Override
    public void setDiscounter(Discounter discounter) {
        this.discounter = discounter;
    }
}
