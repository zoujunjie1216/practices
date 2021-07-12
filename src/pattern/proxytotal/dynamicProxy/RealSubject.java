package pattern.proxytotal.dynamicProxy;

public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void Hello(String str) {
        System.out.println("hello"+str);
    }
}
