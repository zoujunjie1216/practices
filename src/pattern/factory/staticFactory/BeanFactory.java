package pattern.factory.staticFactory;

public class BeanFactory {
    public Sender send(String type){
        if("mail".equalsIgnoreCase(type)){
            return new MailSender();
        }
        if("sms".equalsIgnoreCase(type)){
           return new SMSSender();
        }
        return null;
    }

}
