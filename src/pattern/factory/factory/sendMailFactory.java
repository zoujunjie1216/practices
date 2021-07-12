package pattern.factory.factory;

public class sendMailFactory implements Provider{
    @Override
    public Sender produce() {//Mail工厂类
        return new MailSender();
    }
}
