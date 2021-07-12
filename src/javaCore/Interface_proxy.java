package javaCore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class Interface_proxy {
    public static void main(String[] args) {
        Object[] elements=new Object[1000];
        //fill elements with proxy
        for(int i=0;i<elements.length;i++){
            Integer value=i+1;
            InvocationHandler handler =new Tracehandler(value);
            Object proxy= Proxy.newProxyInstance(null,new Class[]{Comparable.class},handler);
            System.out.println(proxy.getClass());
            Class proxyClass=Proxy.getProxyClass(null,new Class[]{Comparable.class});
          /*  ActionListener actionListener=new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            }*/
            Timer t=new Timer(1000,event-> System.out.println(event));
            Timer t1=new Timer(1000,System.out::println);
            elements[i]=proxy;
        }

        //Contruct a random integer
        Integer key=new Random().nextInt(elements.length)+1;
        //search the key
        int result= Arrays.binarySearch(elements,key);
        //print match if found
        if(result>=0) System.out.println(elements[result]);
    }

    static class Tracehandler implements InvocationHandler {

        private Object target;
        /**
         * Constructs a TraceHandler
         * @param t the implicit parameter of the method call
         * */
        public  Tracehandler(Object t){
            target=t;
        }

        public Object invoke(Object proxy, Method m,Object[] args)throws Throwable{
           //print implict argument
            System.out.println(target);
            //print method name
            System.out.println("."+m.getName()+"(");
            //print exclicit arguments
            if(args!=null){
                for(int i=0;i<args.length;i++){
                    System.out.println(args[i]);
                    if(i<args.length-1) System.out.println(",");
                }
            }
            System.out.println(")");
            //invoke actual method
            return m.invoke(target,args);
        }
    }

}
