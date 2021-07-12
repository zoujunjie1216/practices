package arithmetic.seqencing;

public class HeapSort {
    /**
     * 堆排序：建立一个堆，堆顶元素最大，最下层元素最小，将堆顶元素和最下层最小元素交换
     * 最大元素在末尾，然后除去这个最大元素，记录这个元素，将其排序在数组的末尾，其余元素在其之前插入
     * */


    public static void main(String[] args) {
        int[] a=new int[]{23,13,2,43,22,1,34,5,56,67,89};
        buildMaxHeapify(a);
        heapSort(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    public static int getParentIndex(int current){
        return (current-1)>>1; //就是current-1/2
    }

    public static  int getLeftChildIndex(int current){
        return (current<<1)+1;//current*2+1
    }

    public static int getRightChildIndex(int current){
        return (current<<1)+2; //current*2+2
    }
    public static void buildMaxHeapify(int[] arr){
        int startIndex=getParentIndex(arr.length-1);
        for (int i=startIndex;i>=0;i--){
          maxHeapify(arr,arr.length,i);
        }
    }
    /**
     * 创建最大堆 堆排序，递归方式
     * @param arr
     * @param heapSize 需要创建最大堆的大小，一般在sort时用到
     * @param index
     */

    public static void maxHeapify(int[] arr,int heapSize,int index){
        int left=getLeftChildIndex(index);
        int right=getRightChildIndex(index);
        int largest=index;
        if(left<heapSize&&arr[largest]<arr[left]){
            largest=left;
        }
        if (right<heapSize&&arr[largest]<arr[right]){
            largest=right;
        }
        if(largest!=index){
            int temp=arr[largest];
            arr[largest]=arr[index];
            arr[index]=temp;
            maxHeapify(arr,heapSize,largest);
        }
    }

    public static void heapSort(int[] arr){
        for (int i=arr.length-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            maxHeapify(arr,i,0);
        }
    }
}
