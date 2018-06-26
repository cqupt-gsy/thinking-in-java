package programming.practise.design_pattern.chainresponsibility;

public class FieldOneHandler implements Handler {
    private Handler handler;

    @Override
    public void setSuperHandler(Handler handler) {
        this.handler = handler;
    }

    public String handlerRequest(int request) {
        if (request < 5) {
            return "field one";
        } else if (handler != null) {
            return handler.handlerRequest(request);
        }
        return null;
    }
}
