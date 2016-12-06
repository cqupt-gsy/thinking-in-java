package example.practise.design.builder;

public class Builder {
    private Person person;

    public Builder() {
        this.person = new Person();
    }

    public void buildArms(String arms) {
        person.setArms(arms);
    }

    public void buildLegs(String legs) {
        person.setLegs(legs);
    }

    public example.practise.design.builder.Person createPerson() {
        return person;
    }
}
