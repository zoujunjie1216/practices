package arithmetic.matrix;

public class ChangeNum3 {
  //动态规划方法求有找钱有多少种方法
  public static void main(String[] args) {
      System.out.println(ChangeCoins(new int[]{5,2,3},20));
  }
  public static int ChangeCoins(int[]arr,int aims){
      if(arr.length==0||aims<=0||arr==null){
          return 0;
      }
      int answer[][]=new int[arr.length][aims+1];
      for(int i=0;i<arr.length;i++){
          answer[i][0]=1;//第一排的值全部设为1，为0是只有一种解法
      }
      for(int i=1;i<=aims;i++){
          if(i%arr[0]==0){
              answer[0][i]=1;//第一列a0的倍数所在的值设为1
          }
      }
      //从第二排第二列开始动态规划
      for(int i=1;i<arr.length;i++){
          for(int j=1;j<aims+1;j++){
              int num=0;
              for(int k=0;j-arr[i]*k>=0;k++){
                  num+=answer[i-1][j-arr[i]*k];
              }
              answer[i][j]=num;
          }
      }
      return answer[arr.length-1][aims];
  }
}
