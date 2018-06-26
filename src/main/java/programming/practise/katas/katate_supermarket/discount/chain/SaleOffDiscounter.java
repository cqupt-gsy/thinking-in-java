package programming.practise.katas.katate_supermarket.discount.chain;

import programming.practise.katas.katate_supermarket.discount.chain.exception.NoSuchRuleException;
import programming.practise.katas.katate_supermarket.items.Product;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Double.parseDouble;

public class SaleOffDiscounter implements Discounter {

    private final Pattern pattern;
    private Discounter discounter;

    public SaleOffDiscounter(Pattern pattern) {
        this.pattern = pattern;
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
        throw new NoSuchRuleException();
    }

    @Override
    public void setDiscounter(Discounter discounter) {
        this.discounter = discounter;
    }
}
