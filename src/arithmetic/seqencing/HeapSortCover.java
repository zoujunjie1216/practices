package arithmetic.seqencing;

public class HeapSortCover {
    /**
     * 堆排序复写
     *
     * */
    public static void main(String[] args) {
        int[] a=new int[]{23,13,2,43,22,1,34,5,56,67,89};
        buildheap(a);
        heapSort(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    //获得父节点,左子节点，右子节点
    public static int getParent(int a){
        return (a-1)/2;
    }
    public static int getleftChild(int a){
        return (2*a+1);
    }
    public static int getRightChild(int a){
        return 2*(a+1);
    }

    //创建最大堆
    public static void buildheap(int[] a){
        //递归，先找到最后一个值的父节点
        int parent=getParent(a.length-1);
        for(int i=parent;i>=0;i--) {
            heapfiy(a, a.length - 1, i);
        }
    }

    //堆排序
    public static void heapfiy(int[] a, int heapSize,int index) {
        //将最大值放到堆顶
        if(index>=0) {
            int leftChild = getleftChild(index);
            int rightChild = getRightChild(index);
            int max = index;
            if (leftChild < heapSize && a[leftChild] > a[max]) {
                max = leftChild;
            }
            if (rightChild < heapSize && a[rightChild] > a[max]) {
                max = rightChild;
            }
            if (max != index) {
                int temp = a[max];
                a[max] = a[index];
                a[index] = temp;
                heapfiy(a, heapSize, max);
            }
        }
    }

    public static void heapSort(int[] a) {
        //最大堆排序
        for (int i = a.length - 1; i >0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapfiy(a, i, 0);
        }
    }
}
