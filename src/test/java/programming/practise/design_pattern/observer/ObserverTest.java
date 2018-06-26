package programming.practise.design_pattern.observer;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ObserverTest {

    @Test
    public void shouldUpdateNewStateWhenNotifyByListener() {
        //Given
        Observer observers = mock(Observer.class);
        Listener listener = new Listener();
        listener.attach(observers);

        //When
        listener.notifyObservers();

        //Then
        verify(observers, times(1)).update();
    }

    @Test
    public void shouldUpdateNewObserverWhenNotifyObservers() {
        //Given
        NewObserver newObserver = mock(NewObserver.class);
        Listener listener = new Listener();
        listener.attach(newObserver);

        //When
        listener.notifyObservers();

        //Then
        verify(newObserver, times(1)).update();
    }

    @Test
    public void shouldUpdateAllObserversStateWhenListenerNotifyThem() {
        //Given
        FreshObserver freshObserver = mock(FreshObserver.class);
        NewObserver newObserver = mock(NewObserver.class);
        Observer observer = mock(Observer.class);
        Listener listener = new Listener();
        listener.attach(newObserver);
        listener.attach(observer);
        listener.attach(freshObserver);

        //When
        listener.notifyObservers();

        //Then
        verify(newObserver, times(1)).update();
        verify(observer, times(1)).update();
        verify(freshObserver, times(1)).update();
    }

    @Test
    public void shouldNotUpdateObserversStateWhenListenerDettachIt() {
        //Given
        FreshObserver freshObserver = mock(FreshObserver.class);
        NewObserver newObserver = mock(NewObserver.class);
        Observer observer = mock(Observer.class);
        Listener listener = new Listener();
        listener.attach(newObserver);
        listener.attach(observer);
        listener.attach(freshObserver);
        listener.dettach(observer);

        //When
        listener.notifyObservers();

        //Then
        verify(newObserver, times(1)).update();
        verify(freshObserver, times(1)).update();
    }
}
