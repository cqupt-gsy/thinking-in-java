package example.practise.design.facade;

public class FacadeClass {
    private OldClassOne classOne;
    private OldClassTwo classTwo;
    private OldClassThree classThree;

    public FacadeClass(OldClassOne classOne, OldClassTwo classTwo, OldClassThree classThree) {
        this.classOne = classOne;
        this.classTwo = classTwo;
        this.classThree = classThree;
    }

    public void easyApiCall() {
        classOne.methodCall();
        classTwo.dealWithDatabase();
        classThree.dealWithHttp();
    }
}
