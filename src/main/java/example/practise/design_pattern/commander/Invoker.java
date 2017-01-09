package example.practise.design_pattern.commander;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<Commander> commanders = new ArrayList<>();

    public void addCommander(Commander commander) {
        commanders.add(commander);
    }

    public void executeCommander() {
        commanders.forEach(commander -> commander.execute());

    }
}
