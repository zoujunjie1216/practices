package arithmetic.seqencing;

public class MergeSortSquenceCover {
    /**
     * 归并排序复写,分治法，将一组算法用递归拆成不可分的最小组
     * 时间复杂度：O(nlogn) 空间复杂度
     * */
    public static void main(String[] args) {
        int[] a=new int[]{23,13,2,43,22,1,34,5,56,67,89};
        MergeSort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    public static void MergeSort(int[] a,int start,int end){
        int mid=(start+end-1)/2;
        if(start<end) {
            MergeSort(a, start, mid);
            MergeSort(a, mid + 1, end);
            mergefiy(a,start,mid,end);
        }
    }

    public static void mergefiy(int[]a,int low,int mid,int high){
        int[] b=new int[high-low+1];
        int c=low;
        int d=mid+1;
        int e=0;
        while(c<mid+1&&d<=high){
            if(a[c]<a[d]){
            b[e++]=a[c++];
            }else {
                b[e++]=a[d++];
            }
        }
       while (c<=low){
           b[e++]=a[c++];
       }
       while(d<=high){
           b[e++]=a[d++];
       }
      for(int i=0;i<b.length;i++){
          a[low++]=b[i];
      }
    }
}
