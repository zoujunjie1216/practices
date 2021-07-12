package pattern.factory.factory;

public class Test {
    public static void main(String[] args) {
        Provider provider=new sendMailFactory();
        Sender sender=provider.produce();
        sender.send();
    }
}
