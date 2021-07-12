package arithmetic.seqencing;

public class MergeSortSquence {
    /**
     *归并排序法，将两张有序表合成一张有序表
     * 时间复杂度:best O(nlogn) terrible O(nlogn) 空间复杂度: O(1) 稳定
     */
    public static void main(String[] args) {
        int[] a=new int[]{23,13,2,43,22,1,34,5,56,67,89};
        int[]b=mergeSort(a,0,a.length-1);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }

    public static int[] mergeSort(int[] arr,int low,int high){
        //动态递归，将数组拆成最小数组
        int mid=(low+high)/2;
        if(low<high){
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
        return arr;
    }

    public static void merge(int[] arr,int low,int mid,int high){
        int[] temp=new int[high-low+1];
        int i=low;
        int j=mid+1;
        int k=0;
        //拆分的两个两个数组用一个size等于两个数组的size之和的值替代，两个数组都是有序数组，直接比较后拿来使用比较值
        while(i<=mid&&j<=high){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else {
                temp[k++]=arr[j++];
            }
        }
        //补充两个集合剩下的值
        while (i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=high){
            temp[k++]=arr[j++];
        }
        //将temp的值返还给arr
        for (int k2=0;k2<temp.length;k2++){
            arr[k2+low]=temp[k2];
        }
    }
}
