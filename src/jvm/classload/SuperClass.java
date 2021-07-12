package jvm.classload;

import java.util.*;

public class SuperClass {


    public static void main(String[] args) {
      test(8);
    }
    public static void test(int n){
        if(n==2) System.out.println(2);
        if(n==3) System.out.println(3);
        test(n-1);
    }
}
