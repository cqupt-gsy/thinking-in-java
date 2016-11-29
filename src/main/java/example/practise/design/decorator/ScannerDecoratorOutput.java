package example.practise.design.decorator;

public class ScannerDecoratorOutput extends BasicDecoratorOutputClass {
    public ScannerDecoratorOutput() {
    }

    public ScannerDecoratorOutput(OutputClass outputClass) {
        super(outputClass);
    }

    @Override
    public String output() {
        if (outputClass != null) {
            return "Scanner Decorator Output";
        }
        return super.output();
    }
}
