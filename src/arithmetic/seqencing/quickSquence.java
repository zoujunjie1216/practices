package arithmetic.seqencing;

import java.lang.reflect.Array;

public class quickSquence {
    /**
     * 快速排序，1.计算中轴，2.分割数组 3启动排序
     * 时间复杂度:best O(nlogn) terrible o(n2) 空间复杂度: O(nlogn) 不稳定
     * */
    public static void main(String[] args) {
        int[] a=new int[]{23,13,2,43,22,1,34,5,56,67,89};
        quickSort(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    //通过动态的挪移元素来查找中轴位，通过中轴将数组划分成两部分，左边小于中轴，右边大于中轴
    public static int getMiddle(int[] arr,int low,int high){
        int temp=arr[low];
        while (low<high) {
            //low低于high时一直进行交换，拿高位低于temp的值和低位高于temp的值进行交换，最后low=high=temp即中值，左边小于temp，右边大于temp
            while (low<high&&arr[high]>=temp){
                high--;
            }
            arr[low]=arr[high];
            while (low<high&&arr[low]<temp){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }

    public static void divide(int arr[],int low,int high){
        if(low<high){
            int middle=getMiddle(arr, low, high);
            divide(arr,low,middle-1);
            divide(arr,middle+1,high);
        }
    }

    public static void quickSort(int[] arr){
        if(arr.length>0){
            divide(arr,0,arr.length-1);
        }
    }
}
