package spring;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;

class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // String b=sc.nextLine();
        String b="a";
        String[] a=b.split("/");
        LinkedList<String> queue=new LinkedList();
        for(int c=0;c<a.length;c++) {
            if(a[c].equals("")) continue;
            if(a[c].equals(".")) continue;
            if(a[c].equals("..")) {
            queue.removeLast();
            continue;
            }
            queue.add(a[c]);
        }
        StringBuffer fin=new StringBuffer();
        for(String temp:queue) {
          fin.append("/"+temp);
        }
        System.out.println(fin.toString());
    }

}
