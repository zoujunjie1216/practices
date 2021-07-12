package pattern.observer.listen;

public interface PersonListener {
    //被监听者接口，所有监听者需要实现该接口
    void doeat(Event p);
    void dorun(Event p);
}
