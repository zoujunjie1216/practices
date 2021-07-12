package arithmetic.matrix;

public class ChangeNum2 {
        //找钱问题记忆搜索法，动态规划变形方法
        public static void main(String[] args) {
            System.out.println(getChangeNum(new int[]{5,2,3},10));
        }
        public static int getChangeNum(int[] arr,int aims){
            if(arr.length==0||arr==null||aims<=0){
                return 0;
            }
            int[][] map=new int[arr.length+1][aims+1];
          return getNum(map,arr,0,aims);
        }
        public static int getNum(int[][]a,int[]arr,int index,int aims){
            int res=0;
            if(index==arr.length){
                res=aims==0?1:0;
            }else {
                int mapValue=0;
                for(int i=0;arr[index]*i<=aims;i++){
                    if(a[index+1][aims-arr[index]*i]!=0){
                    mapValue=a[index+1][aims-arr[index]*i];
                    res+=mapValue==-1?0:mapValue;
                }else {
                        res += getNum(a, arr, index + 1, aims - arr[index] * i);
                    }
                }
            }
            a[index][aims]=res==0?-1:res;
            return res;
        }

}
