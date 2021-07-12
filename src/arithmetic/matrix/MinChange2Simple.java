package arithmetic.matrix;

public class MinChange2Simple {
    //找钱不限张数优化过程，空间优化，不在需要arr.length行，将值覆盖一遍
    public static void main(String[] args) {
        System.out.println(minCoins(new int[]{5,2,3},14));
    }
    public static int minCoins(int[]a,int aims){
        if(a.length==0||a==null||aims<=0){
            return -1;
        }
        int[] answer=new int[aims+1];

        int max=Integer.MAX_VALUE;
        for(int i=1;i<aims+1;i++){
            if(i%a[0]==0){
                answer[i]=i/a[0];
                continue;
            }
            answer[i]=max;
        }
        int tmp=0;
        int length=a.length;
    for(int i=0;i<length;i++){
        for(int j=0;j<aims+1;j++){
            tmp=max;
            if(j>a[i]&&answer[j-a[i]]!=max){
                tmp=answer[j-a[i]]+1;
            }
            answer[j]=Math.min(tmp,answer[j]);
        }
    }
     return answer[aims]==max?-1:answer[aims];
    }

}
