package example.practise.design.iterator;

public class AggregateObject {

    private String firstField;
    private String secondField;
    private String thirdField;


    public Iterator createAscIterator() {
        return new AscIterator(this);
    }

    public Iterator createDescIterator() {
        return new DescIterator(this);
    }

    public void setFirstField(String firstField) {
        this.firstField = firstField;
    }

    public void setSecondField(String secondField) {
        this.secondField = secondField;
    }

    public void setThirdField(String thirdField) {
        this.thirdField = thirdField;
    }
}
