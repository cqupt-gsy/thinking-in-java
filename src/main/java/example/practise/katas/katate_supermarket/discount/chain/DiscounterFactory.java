package example.practise.katas.katate_supermarket.discount.chain;

public class DiscounterFactory {

    private Discounter noneDiscounter;

    public DiscounterFactory() {
        this.noneDiscounter = new NoneDiscounter();
        final Discounter buyXForYDiscounter = new BuyXForYDiscounter();
        this.noneDiscounter.setDiscounter(buyXForYDiscounter);
        final Discounter saleOffDiscounter = new SaleOffDiscounter();
        buyXForYDiscounter.setDiscounter(saleOffDiscounter);
    }

    public Discounter getDiscounter() {
        return noneDiscounter;
    }
}
