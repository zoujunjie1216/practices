package pattern.factory.factory;

public class SendSMSFactory implements Provider {
    @Override
    public Sender produce() {//SMS工厂类
        return null;
    }
}
