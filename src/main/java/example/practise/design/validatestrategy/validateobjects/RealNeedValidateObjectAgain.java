package example.practise.design.validatestrategy.validateobjects;

public class RealNeedValidateObjectAgain extends ValidateObject {
    private String others;

    public String getOthers() {
        System.out.println("other error");
        return others;
    }
}
