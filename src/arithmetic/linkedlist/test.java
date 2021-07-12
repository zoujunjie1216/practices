package arithmetic.linkedlist;

public class test {
    public static void main(String[] args) {
      int[] a=new int[]{1,2,3,4,5};
      int[] b=sortedSquares(a);
        System.out.println(1);
    }


    public static int[] sortedSquares(int[] A) {
        int start=0;
        int length=A.length;
        int end=length-1;
        int[] fin=new int[length];
        while(length>0){
            if(A[start]*A[start]>A[end]*A[end]){
               fin[length-1]= A[start]*A[start];
               start++;
            }else {
                fin[length-1]=A[end]*A[end];
                end--;
            }
            length--;
        }
        return fin;
    }
}
