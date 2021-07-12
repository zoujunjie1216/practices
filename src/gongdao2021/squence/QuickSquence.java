package gongdao2021.squence;

public class QuickSquence {
    public int getMiddle(int[] a,int left ,int right){
        int temp =a[left];
        while (left<right){
            while (left<right&&a[right]>temp){
                right--;
            }
            a[left]=a[right];
            while (left<right&&a[left]<temp){
                left++;
            }
            a[right] = a[left];
        }
        a[left] =temp;
        return left;
    }
    public void deivde(int[] a,int left,int right){
        //判断条件 需要 这边不加无限递归 递归一定要加条件
        if(left<right){
            int mid =getMiddle(a,left,right);
            deivde(a,left,mid-1);
            deivde(a,mid+1,right);
        }
    }
    public void quickSort(int[] a){
        if(a==null||a.length<=1) return;
        deivde(a,0,a.length-1);
    }
}
