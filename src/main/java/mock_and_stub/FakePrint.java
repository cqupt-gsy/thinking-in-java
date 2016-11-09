package mock_and_stub;

public class FakePrint implements Print {
    private boolean print;
    private String printString;

    public boolean isPrint() {
        return print;
    }

    @Override
    public void print(String printStr) {
        print = true;
        printString = printStr;
    }

    public String printString() {
        return printString;
    }
}
