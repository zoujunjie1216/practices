package arithmetic.matrix;

public class ChangeNum {
    //找钱问题：给定零钱数组，算出一共有多少种解法
    //动态递归（暴力递归解法，算出每一种可能然后相加），当数量巨大时，时间暴增
    public static void main(String[] args) {
        System.out.println(minWayNum(new int[]{5,2,3},10));
    }
    public static int minWayNum(int[] a,int aims){
        if(aims<=0||a.length==0||a==null){
            return 0;
        }
        return getCoinsNum(a,0,aims);
    }
    public static int getCoinsNum(int[]a,int index,int aims){
        int res=0;//计算值
        if(index==a.length){
            res=aims==0?1:0;
        }else {
            for(int i=0;a[index]*i<=aims;i++){
                  res+=getCoinsNum(a,index+1,aims-a[index]*i);
            }
        }
        return res;
    }
}
