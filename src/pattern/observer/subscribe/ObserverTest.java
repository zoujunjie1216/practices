package pattern.observer.subscribe;

public class ObserverTest {
    public static void main(String[] args) {
        User user1 = new User("江晨星");
        User user2 = new User("曾文静");
        User user3 = new User("欧阳娜娜");
        WechatServer we = new WechatServer();
        we.registerObserver(user1);
        we.registerObserver(user2);
        we.registerObserver(user3);
        we.setmassage("都是弟弟");
    }
}
