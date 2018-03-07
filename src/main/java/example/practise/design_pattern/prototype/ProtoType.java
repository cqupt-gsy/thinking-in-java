package example.practise.design_pattern.prototype;

public class ProtoType implements Cloneable {
    private String name;
    private int value;
    private Person person;
    private Person person_1;

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Person getPerson_1() {
        return person_1;
    }

    public void setPerson_1(Person person_1) {
        this.person_1 = new Person(person_1.getName(), person_1.getValue());
    }
}
