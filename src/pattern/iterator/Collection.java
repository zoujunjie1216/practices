package pattern.iterator;

public interface Collection {
    public Iterator iterator();
    //取得元素
    public Object get(int i);
    //取得集合大小
    public int size();
}
