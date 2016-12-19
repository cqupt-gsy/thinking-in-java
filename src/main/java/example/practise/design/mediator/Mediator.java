package example.practise.design.mediator;

public class Mediator {
    private SystemClass systemOneClass;
    private SystemClass systemTwoClass;

    public void setSystemOne(SystemClass systemClass) {

        this.systemOneClass = systemClass;
    }

    public void setSystemTwo(SystemClass systemClass) {

        this.systemTwoClass = systemClass;
    }

    public void sendMessage(String msg, SystemClass systemClass) {
        if (systemClass == systemOneClass) {
            systemTwoClass.notifyUpdate(msg);
        } else {
            systemOneClass.notifyUpdate(msg);
        }
    }
}
