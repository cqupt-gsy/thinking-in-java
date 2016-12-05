package example.practise.design.template;

import static java.lang.System.out;

public abstract class TemplateClass {
    public String getResult() {
        out.println("first step");
        String result = operator();
        out.println("last step");
        return result;
    }

    protected abstract String operator();
}
