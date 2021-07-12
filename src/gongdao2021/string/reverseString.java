package gongdao2021.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 反转链表
 * */
public class reverseString {
    //调用java api
    //核心思想也是这四步
    public String reverseWords(String s) {
        //祛除空格
        String trims = s.trim();
        //转成集合
        String[] sarr = trims.split("\\s+");
        List<String> arrList = Arrays.asList(sarr);
        //反转
        Collections.reverse(arrList);
        //拼接
        return String.join(" ",arrList);
    }
}
