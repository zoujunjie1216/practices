package arithmetic.matrix;

public class MinChange3 {
    //动态规划找钱问题3，所给的钱有数量限制，这时判断条件改变
    public static void main(String[] args) {
        System.out.println(minCoins(new int[]{5,2,3,1},1));
    }
    public static int minCoins(int[] arr,int aim){
        if(arr==null||aim<0||arr.length==0) {
            return -1;
        }
        int max=Integer.MAX_VALUE;
        int i=1;
        int[][] answer=new int[arr.length][aim+1];
        //第一排的值只将第一个值等于arr[0]的地方设为一，其他全部为max
        while(i<aim+1){
            if(i==arr[0]){
                answer[0][i]=1;
                i++;
                continue;
            }
            answer[0][i]=max;
            i++;
        }
        int left;//设置比较值
        for(int m=1;m<arr.length;m++){
            for(int n=1;n<aim+1;n++){
                //从第二行第二列开始遍历
                left=max;
                if(n>=arr[m]&&answer[m-1][n-arr[m]]!=max){
                    left=answer[m-1][n-arr[m]]+1;
                }
                answer[m][n]=Math.min(left,answer[m-1][n]);
            }
        }
        return answer[arr.length-1][aim]==max?-1:answer[arr.length-1][aim];
    }
}
