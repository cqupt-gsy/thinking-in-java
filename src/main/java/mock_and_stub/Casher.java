package mock_and_stub;

public class Casher {
    private FakePrint print;

    public void setPrint(FakePrint print) {
        this.print = print;
    }

    public void print(String printString) {
        print.print(printString);
    }
}
