package example.practise.design_pattern.strategy;

public class Discounter extends DiscounterStrategy {
    private double discountRate;

    public Discounter(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double getResult(double money) {
        return money * discountRate;
    }
}
