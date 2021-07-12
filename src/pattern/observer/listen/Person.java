package pattern.observer.listen;

public class Person {
    /**
     * 事件源,事件源上发生一个动作时，他会调用时间监听器的一个方法，并在调用该方法时将事件对象传递进去
     */
    private PersonListener personListener;

    public void eat(){
        if(personListener!=null){
            personListener.doeat(new Event(this));
        }
    }

    public void run(){
        if(personListener!=null){
            personListener.dorun(new Event(this));
        }
    }

    public void registerListener(PersonListener personListener){
        this.personListener=personListener;
    }
}
