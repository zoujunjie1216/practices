package gongdao2021;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class SpecialStructAndMethod {

    public void struct(){
        //链表方法
        //linkedList 是双向链表
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.offerFirst("");
        linkedList.offerLast("");
        //queue
        Queue<String> queue = new LinkedList<>();
        //往队列头加
        queue.offer("aaa");
        //从头拿出元素 获取并移除
        queue.poll();
        //获取但是不移除
        queue.peek();
        queue.add("bbb");
        //数据结构 -
        List copyList = new CopyOnWriteArrayList();
    }

    public void structString(){
        String a = "sdfsdfsdfsfsdf";
        System.out.println(a.charAt(0));
        System.out.println(a.indexOf('s'));
    }

    public void structList(){
        List<String> child =new ArrayList<>();
        //返回拼接后的字符串
        String joinString = String.join(".",child);
        //交换集合中的两个元素
        Collections.swap(child,0,1);
        //返回一维数组写法
        String[] childArray =  child.toArray(new String[0]);
        //返回二维数组写法
        int[][] fin =child.toArray(new int[0][]);
    }

    public void structStack(){
        Stack<String> stack = new Stack<>();
        stack.size();
        stack.isEmpty();
        stack.get(0);
    }

    public void structArray(){
        int[] a = new int[5];
        //排序
        Arrays.sort(a);
        //部分排序
        Arrays.sort(a,1,3);
        //数组填充
        Arrays.fill(a,1);
        Arrays.fill(a,1,3,0);
        
        List<Integer> b = Arrays.asList(1,2,3);

    }

    public static void main(String[] args) {
        String a = "sdfsdfsdfsfsdf";
        System.out.println(a.indexOf('d'));
        System.out.println(a.charAt(1));
        char[] aString =  a.toCharArray();
        System.out.println(aString[0]);
    }
}
