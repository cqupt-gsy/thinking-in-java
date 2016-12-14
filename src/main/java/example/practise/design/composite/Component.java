package example.practise.design.composite;

public interface Component {
    void addChild(Component child);

    String display(int depth);
}
