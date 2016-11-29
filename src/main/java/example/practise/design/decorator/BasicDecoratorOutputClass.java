package example.practise.design.decorator;

public class BasicDecoratorOutputClass extends OutputClass implements DecoratorOutputOperator {

    protected OutputClass outputClass;

    public BasicDecoratorOutputClass() {
    }

    public BasicDecoratorOutputClass(OutputClass outputClass) {
        this.outputClass = outputClass;
    }

    @Override
    public String output() {
        if (outputClass != null) {
            return "Basic Decorator Output";
        }
        return super.output();
    }
}
