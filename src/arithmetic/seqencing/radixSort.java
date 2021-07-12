package arithmetic.seqencing;

//基数排序，bucketSort又称桶排序
public class radixSort {
    /**
     * 按照数组中的数字的个位数排序，然后再按照十位数排序
     * 空间复杂度O(n) 时间复杂度O(n)-O(nlogn)
     * */
    public static void main(String[] args) {
        int[] a=new int[]{13,13,13,13,1,1,34,5,56,67,89,63};
        radixSort(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static void radixSort(int[] arr){
        int maxDigit=0;
        for(int i:arr){
            maxDigit=Math.max(maxDigit,Integer.toString(i).length());
        }
        int[][] bucket=new int[10][arr.length];
        int[] order=new int[10];
        int n=1;
        for(int m=1;m<=maxDigit;m++,n*=10){
            for(int i=0;i<arr.length;i++){
                int lsd=((arr[i]/n)%10);
                bucket[lsd][order[lsd]]=arr[i];
                order[lsd]++;
            }
        for(int i=0,k=0;i<10;i++){
            //这里是先进行按个位排序，然后在按十位进行排序
            if(order[i]!=0){
                for(int j=0;j<order[i];j++,k++){
                    arr[k]=bucket[i][j];
                }
            }
            order[i]=0;
        }
        }
    }

}
