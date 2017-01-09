package example.practise.design_pattern.mediator;

public interface SystemClass {
    void sendMessage(String msg);

    String getMessage();

    void notifyUpdate(String msg);
}
