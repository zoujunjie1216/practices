package arithmetic.matrix;

public class MinChange2 {
    //给定钱数数组，和指定钱数，求所需最小张数
    //用动态规划的方法，建立动态规划表，之后还可以进行空间压缩，不用动态规划的方法见minchange
    public static void main(String[] args) {
        System.out.println(minCoins(new int[]{5,2,3,10},21));
    }
    public static int minCoins(int[]a,int aim){
        if(a==null||a.length==0||aim<0){
            return -1;
        }
        int n=a.length;
        int max=Integer.MAX_VALUE;
        int[][] dp=new int[a.length][aim+1];
        for(int i=1;i<=aim;i++){
            dp[0][i]=max;
            //将目标钱数和所给钱的大小作比对，数目*面值=目标钱数
            if(i-a[0]>=0&&dp[0][i-a[0]]!=max){
                dp[0][i]=dp[0][i-a[0]]+1;
            }
        }
        int left=0;
        for(int i=1;i<n;i++){
            for(int j=1;j<=aim;j++){
                left=max;
                if(j-a[i]>=0&&dp[i][j-a[i]]!=max){
                    left=dp[i][j-a[i]]+1;
                }
                dp[i][j]=Math.min(left,dp[i-1][j]);
            }
        }
        return dp[n-1][aim]!=max?dp[n-1][aim]:-1;
    }
}
