package example.practise.design_pattern.adapter;

public class Adapter extends OldClass {

    private Adaptee adaptee = new Adaptee();

    public String getResult() {
        return adaptee.doSomethingSepcial();
    }
}
