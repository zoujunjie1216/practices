package jvm.classload;

public class SubClass extends SuperClass {
    static {
        System.out.println("subclass init");
    }
}
