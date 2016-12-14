package example.practise.design.memento;

public class Originator {
    private int originalValue;

    public Originator(int originalValue) {

        this.originalValue = originalValue;
    }

    public Memento createMemento() {
        return new Memento(originalValue);
    }

    public void changeNewValue(int newValue) {
        originalValue = newValue;
    }

    public void rollback(Memento memento) {
        originalValue = memento.getOriginalValue();
    }

    public int getOriginalValue() {
        return originalValue;
    }
}
