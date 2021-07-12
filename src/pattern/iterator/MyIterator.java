package pattern.iterator;

public class MyIterator implements Iterator {

    private Collection collection;
    private int pos=-1;

    public MyIterator(Collection collection) {
        this.collection = collection;
    }

    @Override
    public Object Previous() {
        if(pos>0){
            pos--;
        }
        return collection.get(pos);
    }

    @Override
    public Object next() {
        if(pos<collection.size()-1){
            pos++;
        }
        return collection.get(pos);
    }

    @Override
    public boolean hasnext() {
        if(pos<collection.size()-1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Object first() {
        return collection.get(0);
    }
}
