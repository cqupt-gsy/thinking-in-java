package example.practise.design_pattern.chainresponsibility;

public class FieldTwoHandler implements Handler {
    private Handler handler;

    @Override
    public void setSuperHandler(Handler handler) {

        this.handler = handler;
    }

    @Override
    public String handlerRequest(int request) {
        if (request > 5 && request < 10) {
            return "field two";
        } else {
            if (handler != null) {
                return handler.handlerRequest(request);
            }
        }
        return null;
    }
}
