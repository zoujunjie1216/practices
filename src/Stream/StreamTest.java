package Stream;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StreamTest  {

    public static void main(String[] args) {

        Map map=new Hashtable<Integer,String>();
        map.put(1,"aaa");
        map.put(2,"aaa");
        map.put(3,"aaa");
        map.put(4,"aaa");
        map.put(5,"aaa");
        map.put(6,"aaa");



        /*List<Integer> integerList=new ArrayList<>(8);
        integerList.add(15);
        integerList.add(32);
        integerList.add(15);
        integerList.add(32);
        integerList.add(12);
        integerList.add(15);
        integerList.add(16);
        integerList.add(17);
        integerList.add(15);
        integerList.add(32);
        integerList.add(12);
        integerList.add(15);
        integerList.add(16);
        integerList.add(17);*/
    }

    public void testmap(){
        List<Integer> integerList=new ArrayList<>();
        integerList.add(15);
        integerList.add(32);
        integerList.add(12);
        integerList.add(15);
        integerList.add(16);
        integerList.add(17);
        List<String> afterString =integerList.stream().map(i->String.valueOf(i)).collect(Collectors.toList());

        Map map=new HashMap<Integer,String>();
        map.put(1,"aaa");

        new ConcurrentHashMap<>();
    }
}
