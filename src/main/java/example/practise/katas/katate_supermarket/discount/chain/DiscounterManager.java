package example.practise.katas.katate_supermarket.discount.chain;

import java.util.regex.Pattern;

import static example.practise.katas.katate_supermarket.discount.chain.patterns.DiscounterRulePattern.BUY_X_FOR_Y_PATTERN;
import static example.practise.katas.katate_supermarket.discount.chain.patterns.DiscounterRulePattern.SALE_OFF_PATTERN;

public class DiscounterManager {

    private Discounter noneDiscounter;

    public DiscounterManager() {
        this.noneDiscounter = new NoneDiscounter();
        final Discounter buyXForYDiscounter = new BuyXForYDiscounter(Pattern.compile(BUY_X_FOR_Y_PATTERN));
        this.noneDiscounter.setDiscounter(buyXForYDiscounter);
        final Discounter saleOffDiscounter = new SaleOffDiscounter(Pattern.compile(SALE_OFF_PATTERN));
        buyXForYDiscounter.setDiscounter(saleOffDiscounter);
    }

    public Discounter getDiscounter() {
        return noneDiscounter;
    }
}
