package example.practise.design_pattern.composite;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.repeat;

public class Composite implements Component {
    private String nodeName;
    private List<Component> components = new ArrayList<>();

    public Composite(String nodeName) {
        this.nodeName = nodeName;
    }

    @Override
    public void addChild(Component child) {
        components.add(child);
    }

    @Override
    public String display(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(repeat("-", depth) + nodeName);
        stringBuilder.append("\n");
        components.forEach(component -> stringBuilder
                .append(component.display(depth + 2)) );
        return stringBuilder.toString();
    }
}
