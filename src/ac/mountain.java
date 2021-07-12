package ac;

import java.io.Serializable;
import java.util.Scanner;
import java.util.Stack;

public class mountain  implements Serializable {
    //环形山例题，输入实例6 1 3 2 5 4 6 取得次数 9
    //单调栈问题求解 2019.2.28
    //最小栈

    public static void main(String[] args) {
        //获得输入数据
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
            int size=scanner.nextInt();
            int[] a=new int[size];
            for(int i=0;i<size;i++){
                a[i]=scanner.nextInt();
            }
            System.out.println(communications(a));
        }

        }

    public static int nextindex(int size,int i){
        return i<(size-1)?(i+1):0;
    }
    //相邻相同山峰之间的对数，若只有一个，则没有成对，两个以上计算内部成对数
    public static long getInternalSum(int n){
        return n==1L?0L:(long)n*(long)(n-1)/2L;
    }
    public static class Pair{
        public int value;
        public int times;

        public Pair(int values){
            this.value=values;
            this.times=1;
        }
    }

    public static long communications(int[] a){
        if(a==null||a.length<2){
            return 0;
        }//排除数量小于二
        int size=a.length;
        int maxindex=0;
        for(int i=0;i<size;i++){
            maxindex=a[maxindex]<a[i]?i:maxindex;//获得最大值
        }
        int value=a[maxindex];//最高山峰的高度
        int index=nextindex(size,maxindex);//下一个高峰的位置
        long res=0L;
        Stack<Pair> stack=new Stack<Pair>();
        stack.push(new Pair(value));
        while(index!=maxindex) {
            value = a[index];
            while (!stack.isEmpty() && stack.peek().value < value) {
                 int times=stack.pop().times;
                 res+=getInternalSum(times)+times*2;//栈底为最大元素，不可弹出
            }
            if (!stack.isEmpty() && stack.peek().value == value) {
                stack.peek().times++;
            } else {
                stack.push(new Pair(value));
            }
            index = nextindex(size, index);
        }
        while(!stack.isEmpty()){
            int times=stack.pop().times;
            res+=getInternalSum(times);
            if(!stack.isEmpty()){
                res+=times;
                if(stack.size()>1){
                    res+=times;
                }else{
                    res+=stack.peek().times>1?times:0;
                }
            }
        }
        return res;
    }
}
