package jvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("i am xiaoshuibi");
        list.add("zoujj is a xiaoshuibi");
        list.add("i am zoujj");
        List<String> newList=list.stream().map(str->str.split(" "))
                     .flatMap(Arrays::stream)
                    // .distinct()
                     .collect(Collectors.toList());
        Iterator<String> a=newList.iterator();
        while (a.hasNext()){
            System.out.println(a.next());
        }

    }
}
