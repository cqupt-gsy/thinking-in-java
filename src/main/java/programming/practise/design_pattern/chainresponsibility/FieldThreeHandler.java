package programming.practise.design_pattern.chainresponsibility;

public class FieldThreeHandler implements Handler {
    private Handler handler;

    @Override
    public void setSuperHandler(Handler handler) {

        this.handler = handler;
    }

    @Override
    public String handlerRequest(int request) {
        if (request > 10) {
            return "field three";
        } else {
            if (handler != null) {
                return handler.handlerRequest(request);
            }
        }
        return null;
    }
}
