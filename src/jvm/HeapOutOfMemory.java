package jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOutOfMemory {
    /**
     * Vm args: -Xms20m -Xmx20x -XX:+HeapDumpOnOUtOfMemoryError
     * */
    static  class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<OOMObject>();

        while (true){
            list.add(new OOMObject());
        }
    }
}
