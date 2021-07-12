package arithmetic.String;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class delete0 {
    /**
     * 删除指定长度的0
     */
    public static void main(String[] args) {
        System.out.println(removeZero( "sd000f000saf0000das000d",3));
    }

    public static String delete(int num, String a) {
        //测试字符数组和字符串之间的相互转化
        /*
        char[] c=new char[]{'a','b','c'};
        String[] test=new String[]{"134","sadfas","sdfas"};
        String b= Arrays.toString(test);
        String d=Arrays.toString(test);
        return new String(c);*/
        //遍历字符串
        char[] chars = a.toCharArray();
        List<Character> list = new ArrayList<Character>();
        for (char dele : chars) {
            list.add(dele);
        }
        int test = num;
        //将符合的子串直接删除
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == '0') {
                test--;
            } else {
                if (test == 0) {
                    for (int j = 0; j < num; j++) {
                        list.remove(i - num);
                    }
                    i = i - num;
                }
                test = num;
            }
        }

        return list.toString();
    }

    public static String removeZero(String str, int k) {
        if (str == null || k == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        int count = 0, start = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                count++;
                start = start == -1 ? i : start;
            } else {
                if (count == k) {
                    while (count-- != 0)
                        chars[start++] = 0;
                }
                    count = 0;//不加也行
                    start = -1;
                }
        }
            if (count == k) {
                while (count-- != 0) {
                    chars[start++] = 0;
                }
        }
            return String.valueOf(chars).trim();
        }
}