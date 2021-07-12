package pattern.proxytotal.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Sourceable sourceable=new proxy();
        sourceable.method();
    }
}
