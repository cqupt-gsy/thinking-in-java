package example.practise.design.builder;

public class Person {
    private String arms;
    private String legs;

    public void setArms(String arms) {
        this.arms = arms;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        return arms + " " + legs;
    }
}
