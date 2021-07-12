package pattern.proxytotal.proxy;

public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("the origin method");
    }
}
