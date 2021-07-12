package pattern.observer.listen;

public class ImPersonListener implements PersonListener {
    //被监听者实例，可以被监听者获得

    @Override
    public void doeat(Event e) {
        String a="江";
        Person p=e.getPerson();
        System.out.println(p+a);
    }

    @Override
    public void dorun(Event e) {
        String a="静";
        Person p=e.getPerson();
        System.out.println(p+a);
    }

    public  void modify(){

    }
}

