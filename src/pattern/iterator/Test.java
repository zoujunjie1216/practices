package pattern.iterator;

public class Test {
    public static void main(String[] args) {
        Collection collection=new MyCollection();
        Iterator it=collection.iterator();
        while (it.hasnext()){
            System.out.println(it.next());
        }

    }
}
