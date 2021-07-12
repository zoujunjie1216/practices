package ac.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 最大公因数和最小公倍数
 * */
public class MinMax {
    //辗转相除法，最大公因数(欧几里法)
    public static int maxFactor(int x,int y){
        int a,b,c;
        a=x;
        b=y;
        while (b!=0){
            c=a%b;
            a=b;
            b=c;
        }
        return a;
    }
    //欧几里算法，最大公因数
    public static int maxFactor2(int a,int b){
        if(b==0) return a;
        return maxFactor2(b,a%b);
    }

    //相减法
    public static int decrease(int a,int b){
        while(a!=b){
            if(a>b){
                a=a-b;
            }else{
                b=b-a;
            }
        }
        return  a;
    }

    //最大公倍数(1)
    public static int doubleSum(int a,int b){
        int sum=a*b;
        return sum/decrease(a,b);
    }

    public int videoStitching(int[][] clips, int T) {
        //动态规划
        //类似锁链，第一个位置肯定是第一个值，然后第一个值到最大值的范围内选择下一个可以到最远值的值
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        return 1;
    }

    //动态规划
    public int videoStitching1(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }
    //贪心算法
    public int videoStitching2(int[][] clips, int T) {
        int[] maxn = new int[T];
        int last = 0, ret = 0, pre = 0;
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxn[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(decrease(12,16));
        System.out.println(maxFactor(12,16));
        System.out.println(maxFactor2(12,16));
        System.out.println(doubleSum(12,16));
        Integer a=new Integer(3);
        Integer b=new Integer(3);
        System.out.println(a*b);
       Integer a1=new Integer(128);
       Integer a2=new Integer(128);
        System.out.println(a1.equals(a2));
        String str="a,b,c,c,";
        String[] t=str.split(",");
        System.out.println(t.length);
        int[] p=new int[]{1,2,3};
        List m=Arrays.asList(p);
        List n=new ArrayList();
        n.add(1);
        n.add(2);
        n.add(3);
        n.remove(1);
        System.out.println(n.get(1));
        System.out.println(m.get(1));
        m.remove(1);
        System.out.println(m.get(1));
    }
}
