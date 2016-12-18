package example.practise.design.commander;

public class CookCommander implements Commander {
    private Receiver receiver;

    public CookCommander(Receiver receiver) {

        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
