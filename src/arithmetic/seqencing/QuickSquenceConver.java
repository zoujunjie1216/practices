package arithmetic.seqencing;

public class QuickSquenceConver {
    /**
     *快速排序，将第一个数当成mid，左边的数小于mid，右边的数都大于mid然后在将其用分治法拆分
     * 排序是将第一个数拿出，然后前后比较mid，end小于mid则等于start，start<mid a[start]=a[end]
     * 最后start=end=mid
     *时间复杂度O(nlogn)
     * 空间复杂度0(1)
     * */
    public static void main(String[] args) {
        int[] a=new int[]{23,13,2,43,22,1,34,5,56,67,89};
        getMid(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static int quickSort(int[] a,int start,int end){
        int mid=a[start];
        while (start<end){
            while(a[end]>=mid&&end>start){
               end--;
            }
           a[start]=a[end];
            while(a[start]<mid&&end>start){
                start++;
            }
            a[end]=a[start];
        }
        a[start]=mid;
        return start;
    }

    public static void getMid(int[] a,int start,int end) {
        if (start<end) {
            int mid = quickSort(a, start, end);
            getMid(a, start, mid);
            getMid(a, mid + 1, end);
        }
    }
}
