package pattern.iterator;

public interface Iterator {
    public Object Previous();
    //后移
    public Object next();
    public boolean hasnext();
    //取得第一个元素
    public Object first();
}
