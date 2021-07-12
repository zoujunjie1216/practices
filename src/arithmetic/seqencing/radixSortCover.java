package arithmetic.seqencing;

import java.util.Arrays;

public class radixSortCover {
    /**
     * 桶排序，基数排序复写
     * */
    public static void main(String[] args) {
        int[] a=new int[]{23,13,2,43,22,1,34,5,56,67,89,63};
        radix(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    public static void radix(int[] a){
        int maxDigital=0;
        //整形求长度，用
        for(int arr:a){
            maxDigital=Math.max(maxDigital,Integer.toString(arr).length());
        }
        int m=1;
        //根据位数循环查询
        for(int i=0;i<maxDigital;i++,m=10*m){
            int[][] radix=new int[10][a.length];
            int[] order=new int[10];
            //压入
            for(int j=0;j<a.length;j++) {
                int ldp=(a[j]/m)%10;
                radix[order[ldp]][ldp]=a[j];
                order[ldp]++;
            }
            //取出
            for(int j=0,k=0;j<10;j++){
                if(order[j]!=0){
                    for(int l=0;l<order[j];l++,k++){
                        a[k]=radix[l][j];
                    }
                }

            }
        }

    }
}
