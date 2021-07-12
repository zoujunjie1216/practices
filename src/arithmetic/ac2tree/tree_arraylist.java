package arithmetic.ac2tree;

import ac.cTest;

import java.util.*;

public class tree_arraylist {
    public static void main(String[] args) {
        /*int[][] a = new int[3][];
        for (int i = 0; i < 3; i++) {
            a[i] = new int[i];
            for (int j = 0; j < i; j++) {
                a[i][j] = 1;
            }
            System.out.println("1");*/
        test();
    }

    public static void test() {
        //list属性
        List arrayList=new ArrayList();
        List<Integer> linkedlist=new LinkedList<Integer>();
        ((LinkedList<Integer>) linkedlist).offer(0);
        linkedlist.add(1);
        linkedlist.add(2);
        linkedlist.add(3);
        linkedlist.add(4);
        linkedlist.add(5);
        linkedlist.add(6);
        ((LinkedList<Integer>) linkedlist).offer(7);
        System.out.println(((LinkedList<Integer>) linkedlist).peekLast());
        System.out.println(((LinkedList<Integer>) linkedlist).peekFirst());
        ((LinkedList<Integer>) linkedlist).offerFirst(99);
        ((LinkedList<Integer>) linkedlist).offerLast(99);
        System.out.println();
        ListIterator<Integer> a=linkedlist.listIterator();
        Iterator<Integer>b=linkedlist.iterator();
        Iterator<Integer>c=((LinkedList<Integer>) linkedlist).descendingIterator();

        while (a.hasNext()){
        System.out.println("正向"+a.next());
        }
        while (a.hasPrevious()){
            System.out.println("反向"+a.previous());
        }
        while (b.hasNext()){
            System.out.println("单向迭代"+a.next());
        }
        System.out.println(linkedlist.lastIndexOf(1));


    Set<Integer> aset=new TreeSet<Integer>();
    cTest test=new cTest();

    }
}
