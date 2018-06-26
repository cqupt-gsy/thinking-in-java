package programming.practise.design_pattern.validatestrategy.validateobjects;

public class RealNeedValidateObjectAgain {
    private String others;

    public String getOthers() {
        System.out.println("other error");
        others = "hello";
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
