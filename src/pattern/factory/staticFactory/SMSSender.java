package pattern.factory.staticFactory;

public class SMSSender implements Sender {
    @Override
    public void send() {
        System.out.println("sms发件人");
    }
}
