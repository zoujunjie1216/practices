package pattern.factory.factory;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("mail发件人");
    }
}
