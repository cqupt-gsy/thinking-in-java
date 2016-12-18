package example.practise.design.chainresponsibility;

public interface Handler {
    void setSuperHandler(Handler handler);

    String handlerRequest(int request);
}
