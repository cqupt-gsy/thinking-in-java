package example.practise.design.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private Map<String, Flyweight> flyweightMaps = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        if (!flyweightMaps.containsKey(key)) {
            if ("first".equals(key)) {
                flyweightMaps.put(key, new FirstFlyweight());
            } else if ("second".equals(key))
                flyweightMaps.put(key, new SecondFlyweight());
        }
        return flyweightMaps.get(key);
    }
}
