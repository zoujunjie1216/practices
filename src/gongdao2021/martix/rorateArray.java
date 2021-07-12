package gongdao2021.martix;

/**
 * 搜索旋转排序数组
 * 二分法 - 和经典的二分法不同 需要判断拆分后的组是否是递增数组
 * OnLog(N)
 * */
public class rorateArray {
    public  int search(int[] nums, int target) {
        //将数组拆分，一个为有序数组，一个可能为有序数组，有序数组折半查找
        //无序数组再拆分，关键在于怎么知道那个为有序数组
        //头尾相减，递增的为正
        if(nums == null || nums.length<1) return -1;
        int left = 0;
        int right = nums.length-1;
        //拆分
        while(left <= right){
            int mid = left+(right-left)/2;
            //以mid为中点切分判断那边是递增数列
            //该部分 二分查找 找到 直接返回 没找到就移动指针
            if(nums[mid]>=nums[left]){
              int re = binarySearch(nums,left,mid,target);
              if(re == -1){
                  left=mid+1;
              }else {
                  return re;
              }
            }
            //和上面一部分一样的 判断条件一次只会进入一个
            //需要等于条件 自身最后一个数的时候 是相等的 或者
            if(nums[mid]<=nums[right]){
                int re = binarySearch(nums,mid,right,target);
                if (re == -1){
                    right = mid-1;
                }else {
                    return re;
                }
            }
        }
        //循环结束 代表没找到 -1
        return -1;
    }


    //先写一个标准的二分查找
    public int binarySearch(int[] nums,int left ,int right,int target){
        //需要= 当起始只有一个数 或者最后只剩下一个数
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]== target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        //未找到
        return -1;
    }


    //错误示范 这变成了递归写法 数组一般不用这种方式
    public int binarySearcherror(int[] nums,int left ,int right,int target){
        int mid = left+(right-left)/2;
        if(nums[mid]== target){
            return mid;
        }else if(nums[mid]<target){
            return binarySearcherror(nums,mid,right,target);
        }else {
            return binarySearcherror(nums,left,right,target);
        }
    }
}
