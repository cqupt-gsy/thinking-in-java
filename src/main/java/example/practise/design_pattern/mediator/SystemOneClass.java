package example.practise.design_pattern.mediator;

public class SystemOneClass implements SystemClass {
    private Mediator mediator;
    private String msg;

    public SystemOneClass(Mediator mediator) {

        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String msg) {
        this.mediator.sendMessage(msg, this);
    }

    @Override
    public String getMessage() {
        return msg;
    }

    @Override
    public void notifyUpdate(String msg) {
        this.msg = msg;
    }
}
