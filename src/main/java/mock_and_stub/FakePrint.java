package mock_and_stub;

public class FakePrint {
    private boolean print;
    private String printString;

    public boolean isPrint() {
        return print;
    }

    public void print(String printStr) {
        print = true;
        printString = printStr;
    }

    public String printString() {
        return printString;
    }
}
