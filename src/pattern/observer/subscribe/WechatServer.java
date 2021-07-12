package pattern.observer.subscribe;

import java.util.ArrayList;
import java.util.List;

public class WechatServer implements Observerable {
    private List<Observer>list;//设计模式的原则是面向接口编程而不是面向实现
    private String message;

    public WechatServer() {
        list=new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
         list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty()){
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i=0;i<list.size();i++){
            Observer observer=list.get(i);
            observer.update(message);
        }
    }

    public void setmassage(String s){
        this.message=s;
        System.out.println("消息跟新");
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
