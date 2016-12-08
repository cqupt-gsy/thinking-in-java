package example.practise.design.validatestrategy;

public class RealNeedValidateObjectAgain extends ValidateObject {
    private String others;

    public String getOthers() {
        System.out.println("other error");
        return others;
    }
}
