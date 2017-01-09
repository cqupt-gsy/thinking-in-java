package example.practise.design_pattern.chainresponsibility;

public interface Handler {
    void setSuperHandler(Handler handler);

    String handlerRequest(int request);
}
