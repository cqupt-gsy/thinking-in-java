package programming.practise.design_pattern.visitor;

public interface Visitee {
    void accept(Visitor visitor);

    String getValue();

    void setValue(String value);
}
