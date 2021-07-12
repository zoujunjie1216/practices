package pattern.proxytotal.proxy;

public class proxy implements Sourceable {

    private Source source;

    public proxy() {
        this.source = new Source();
    }

    @Override
    public void method() {
        System.out.println("method before!");
        source.method();
        System.out.println("method after!");
    }
}
