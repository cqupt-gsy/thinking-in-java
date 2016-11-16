package example.practise.design.strategy;

public class SatisfyReturn extends DiscounterStrategy {
    private int excess;

    public SatisfyReturn(int excess) {
        this.excess = excess;
    }

    @Override
    public double getResult(double money) {
        return 200;
    }
}
