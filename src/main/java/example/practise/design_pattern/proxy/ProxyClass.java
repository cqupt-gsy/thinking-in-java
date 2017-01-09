package example.practise.design_pattern.proxy;

public class ProxyClass {

    private ProxyOutPutClass proxyOutPutClass;

    public String output() {
        if (proxyOutPutClass == null) {
            proxyOutPutClass = new ProxyOutPutClass();
        }
        return proxyOutPutClass.output();
    }
}
