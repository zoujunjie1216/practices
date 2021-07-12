package pattern.adapterAll.classAdapter;

public class Test {
    public static void main(String[] args) {
        //测试类，类适配器测试
        //使用普通功能
        Target contreteTarget=new ConcreteTarget();
        contreteTarget.request();
        //使用特殊功能类
        Target adapter=new Adapter();
        adapter.request();

    }
}
