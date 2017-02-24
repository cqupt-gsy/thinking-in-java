package example.practise.katas.katate_supermarket.discount.chain;

import example.practise.katas.katate_supermarket.items.Product;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static example.practise.katas.katate_supermarket.discount.chain.DiscounterRulePattern.SALE_OFF_PATTERN;
import static java.lang.Double.*;

public class SaleOffDiscounter implements Discounter {

    private Pattern pattern = Pattern.compile(SALE_OFF_PATTERN);
    private Discounter discounter;

    @Override
    public void setDiscounter(Discounter discounter) {
        this.discounter = discounter;
    }

    @Override
    public double calculatePrice(Product product) {
        final Matcher matcher = pattern.matcher(product.getDiscountRule());
        if (matcher.matches()) {
            return product.getNumber() * product.getPrice() * (parseDouble(matcher.group(1)) / 100);
        }
        if (discounter != null) {
            discounter.calculatePrice(product);
        }
        throw new RuntimeException("No such discounter rule");
    }
}
