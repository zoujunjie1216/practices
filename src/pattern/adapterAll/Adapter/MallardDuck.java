package pattern.adapterAll.Adapter;

public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("QUACK");
    }

    @Override
    public void fly() {
        System.out.println("DUCK　FLY");
    }
}
