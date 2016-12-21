package example.practise.design.visitor;

public interface Visitee {
    void accept(Visitor visitor);

    String getValue();

    void setValue(String value);
}
