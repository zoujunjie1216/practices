package arithmetic.String;

public class decisionRepeat2 {
    /**
     * 堆排序，实现判断字符数组是否有重复，使用非递归的方式
     *
     * */
    public static void main(String[] args) {
        System.out.println("是否重复:"+isUnique("wqe45tyer".toCharArray()));
    }

    public static String isUnique(char[] chas){
        if(chas==null){
            return "不重复";
        }
        heapSort(chas);
        for(int i=1;i<chas.length;i++){
            if(chas[i]==chas[i-1]){
                return "重复";
            }
        }
        return "不重复";
    }

    public static void heapSort(char[] chas){
        for(int i=0;i<chas.length;i++){
            heapInsert(chas,i);
        }
        for(int i=chas.length-1;i>0;i--){
            swap(chas,0,i);
            heapify(chas,0,i);
        }
    }

    public static void heapInsert(char[] chas,int i){
        int parent=0;
        while(i!=0) {
            parent = (i - 1) / 2;
            if (chas[parent] < chas[i]) {
                swap(chas, parent, i);
                i = parent;
            } else {
                break;
            }
        }
    }

    public static void heapify(char[] chas,int i,int size){
        int left=i*2+1;
        int right=i*2+2;
        int largest=i;
        while (left<size){
            if(chas[left]>chas[i]){
                largest=left;
            }
            if(right<size&&chas[right]>chas[largest]){
                largest=right;
            }
            if(largest!=i){
                swap(chas,largest,i);
            }else {
                break;
            }
            i=largest;
            left=i*2+1;
            right=i*2+2;
        }
    }

    public static void swap(char[] a,int index1,int index2){
        char tmp=a[index1];
        a[index1]=a[index2];
        a[index2]=tmp;
    }
}
