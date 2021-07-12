package pattern.adapterAll.classAdapter;

public class Adapter extends adaptee implements Target {
    //适配器类，同时实现了标准接口
    @Override
    public void request() {
        super.specificRequest();
    }
}
