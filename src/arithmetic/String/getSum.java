package arithmetic.String;

import java.lang.reflect.Array;

public class getSum {
    /**
     * 字符串内的数值求和
     * A-1B--2C--D6E
     * error:num=num*10+(flag?cur:-cur)是=而不是+=，+=是求和了全部值和个位值和十位值；
     * */
    public static void main(String[] args) {
        System.out.println(getSum("A-128B--2C--D6E"));
    }
    public static int getSum(String sum){
        if(sum.length()==0){
            return 0;
        }
        char[] a=sum.toCharArray();
        boolean flag=true;//标志位
        int num=0;
        int total=0;
        for (int i=0;i<a.length;i++){
            int cur=a[i]-'0';
            //字符不在0-9内
          if(9<cur||cur<0){
              total+=num;
              num=0;
            if(a[i]=='-'){
                flag=!flag;
            }else {
                flag=true;
            }
          }else {
              num=num*10+(flag?cur:-cur);
          }
        }
        total+=num;
        return total;
    }
}
