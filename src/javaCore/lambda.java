package javaCore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Arrays;
import java.util.Date;


public class lambda {
    public static void main(String[] args) {
        String[] planets=new String[]{"mercury","venus","Earth","mars","jupiter","saturn","uranus","neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("sorted order");
        Arrays.sort(planets);
        Runnable a=new Runnable() {
            @Override
            public void run() {
                System.out.println("nihao");
            }
        };
        Thread r=new Thread(a);
        System.out.println(Arrays.toString(planets));
        System.out.println("sort by length");
        Arrays.sort(planets,(String first,String second)->first.length()-second.length());
        System.out.println(Arrays.toString(planets));
        Timer t=new Timer(1000, event->
                System.out.println("this time is"+new Date()));
        String text="23412";
        ActionListener listener=event->{
            System.out.println(text);
            Toolkit.getDefaultToolkit().beep();
        };
        t.start();
    }
}
