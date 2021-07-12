package pattern.observer.listen;

public class Test {
    public static void main(String[] args) {
        Person p=new Person();
        p.registerListener(new ImPersonListener());
        p.eat();
        p.run();
    }
}
