package spring;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class reafect {

    /**
     * 反射获取 字段 方法 注解
     * */
    public static void test(){
        Test a=new Test();
        Class<? extends Test> clazz=a.getClass();
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            String name=field.getName();
            System.out.println(name);
        });
    }
    public static void test2(){
        String a="111";
        String b="111";
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }

    public static void main(String[] args) {
        test2();
        List<Test> list=new ArrayList<>();
        list.sort(new Comparator<Test>() {
            @Override
            public int compare(Test o1, Test o2) {
                return 0;
            }
        });
    }
}
