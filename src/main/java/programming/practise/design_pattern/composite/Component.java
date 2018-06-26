package programming.practise.design_pattern.composite;

public interface Component {
    void addChild(Component child);

    String display(int depth);
}
