package example.practise.design.commander;

public class OrderCommander implements Commander {
    private Receiver receiver;

    public OrderCommander(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
