package pattern.observer.subscribe;

public interface Observerable {
    //抽象主题
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
