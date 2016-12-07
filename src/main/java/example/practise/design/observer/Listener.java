package example.practise.design.observer;

import java.util.ArrayList;
import java.util.List;

public class Listener {

    private List<Observers> observers;

    public Listener() {
        observers = new ArrayList<>();
    }

    public void attach(Observers observers) {
        this.observers.add(observers);
    }

    public void notifyObservers() {
        observers.forEach(observers -> observers.update());
    }

    public void dettach(Observers observer) {
        observers.remove(observer);
    }
}
