package pattern.factory.factory;

public interface Provider {
    //相较简单工厂方法，工厂方法完成闭包将工厂类也变成实现接口，完成多个实现接口
    public Sender produce();
}
