package mock_and_stub;

public class Casher {
    private Print print;

    public void setPrint(Print print) {
        this.print = print;
    }

    public void print(String printString) {
        print.print(printString);
    }
}
