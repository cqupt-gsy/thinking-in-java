package example.practise.katas.katate_supermarket.discount.chain;

public class DiscounterFactory {

    private Discounter noneDiscounter;

    public DiscounterFactory() {
        this.noneDiscounter = new NoneDiscounter();
        final BuyXForYDiscounter buyXForYDiscounter = new BuyXForYDiscounter();
        this.noneDiscounter.setDiscounter(buyXForYDiscounter);
    }

    public Discounter getDiscounter() {
        return noneDiscounter;
    }
}
