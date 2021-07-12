package jvm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RuntimeconstantPoolOOM {
    //线程不安全的类需要为每个类创建实例
    public static final ThreadLocal<SimpleDateFormat> dateFormat=
            ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd"));

    public static void test(){
        String date=dateFormat.get().format(new Date());
        System.out.println(date);
    }

    public static void main(String[] args) {
        test();
    }
}
