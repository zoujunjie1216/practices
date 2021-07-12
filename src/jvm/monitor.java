package jvm;

import java.util.ArrayList;
import java.util.List;

public class monitor {
    static class Jconsole {
        public byte[] placeholder=new byte[64*1024];
    }

    public static void fillHeap(int num) throws InterruptedException{
        List<Jconsole> list=new ArrayList<Jconsole>();
        for(int i=0;i<num;i++){
            Thread.sleep(50);
            list.add(new Jconsole());
        }
        System.gc();

    }

    public static void main(String[] args)throws Exception{
        fillHeap(1000);
    }
}
