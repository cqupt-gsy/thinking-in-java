package example.practise.katas.katate_supermarket.items;

public class Product {
    private final String name;
    private final double price;
    private final String discountRule;
    private long number;

    public Product(String name, double price, String discountRule, long number) {
        this.name = name;
        this.price = price;
        this.discountRule = discountRule;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDiscountRule() {
        return discountRule;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
