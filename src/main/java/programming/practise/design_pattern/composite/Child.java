package programming.practise.design_pattern.composite;

import static org.apache.commons.lang3.StringUtils.repeat;

public class Child implements Component {
    private String nodeName;

    public Child(String nodeName) {
        this.nodeName = nodeName;
    }

    @Override
    public void addChild(Component child) {

    }

    @Override
    public String display(int depth) {
        return repeat("-", depth) + nodeName + "\n";
    }
}
