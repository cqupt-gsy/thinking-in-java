package example.practise.design.strategy;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private List<DiscounterStrategy> strategyList = new ArrayList<>();

    public void addDiscounterStrategy(DiscounterStrategy strategy) {
        strategyList.add(strategy);
    }

    public double getResult(double money) {
        double result = money;
        for (DiscounterStrategy discounterStrategy : strategyList) {
            result = discounterStrategy.getResult(result);
        }
        return result;
    }
}
