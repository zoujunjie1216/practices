package gongdao2021.squence;

/**
 * 归并排序 数组 - 链表的在链表哪里
 * */
public class MergeSquence {
    public int[] mergeArr(int[] arr){
         return mergeSort(arr,0,arr.length-1);
    }

    public int[] mergeSort(int[] arr,int start,int end){
        // depart
        if(start<end){
            int mid = start+(end-start)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr,start,mid,end);
        }
        return arr;
    }

    public int[] merge(int[] arr,int start,int middle ,int end){
        //需要一个新的数组
        int[] temp =new int[end-start+1];
        int i=start;
        int j=middle+1;
        int k=0;
        while (i<middle+1&&j<end+1){
            if (arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else {
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while (i<middle+1){
            temp[k++]=arr[i++];
        }
        while (j<end+1){
            temp[k++]=arr[j++];
        }
        for(int z=0;z<end-start+1;z++){
            arr[z+start] = temp[z];
        }
        return arr;
    }

}
