package example.practise.design.mediator;

public interface SystemClass {
    void sendMessage(String msg);

    String getMessage();

    void notifyUpdate(String msg);
}
