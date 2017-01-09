package example.practise.design_pattern.template;

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
