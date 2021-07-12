package arithmetic.String;

import java.lang.reflect.Array;

public class transfer {
    /**
     * 判断两个字符串是否互为变形词
     * */
    public static void main(String[] args) {
        System.out.println(transfer("qwerty","qwertu"));
    }
    public static boolean transfer(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        char[] a1=s1.toCharArray();
        char[] a2=s2.toCharArray();
        int[] a3=new int[256];
        for(int i=0;i<a1.length;i++){
            a3[a1[i]]++;
        }
        for (int i=0;i<a2.length;i++){
            a3[a2[i]]--;
        }
        for(int i=0;i<a3.length;i++){
            if (a3[i]!=0){
                return false;
            }
        }
        return true;
    }
}
