package example.practise.design.builder;

public class Direct {

    private Builder builder;

    public Direct() {
        builder = new Builder();
    }

    public Person createPerson() {
        builder.buildArms("middle arm");
        builder.buildLegs("middle leg");
        return builder.createPerson();
    }
}
