package example.practise.design.memento;

public class Memento {
    private int originalValue;

    public Memento(int originalValue) {

        this.originalValue = originalValue;
    }

    public int getOriginalValue() {
        return originalValue;
    }
}
