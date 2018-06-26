package programming.practise.design_pattern.decorator;

public class StreamDecoratorOutput extends BasicDecoratorOutputClass {

    public StreamDecoratorOutput() {
    }

    public StreamDecoratorOutput(OutputClass outputClass) {
        super(outputClass);
    }

    public String output() {
        if (outputClass != null) {
            return "Stream Decorator Output";
        }
        return super.output();
    }
}
