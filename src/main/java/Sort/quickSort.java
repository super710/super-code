package Sort;

import java.util.Arrays;

public class quickSort {

    /**
     * 快速排序：
     * 1、快速排序基于冒泡排序演变而来
     * 2、冒泡排序每次遍历只把一个一个元素移到数列的一端，
     * 快排每次挑选一个基准元素（分治法），并且保证左右两边元素以基准元素为边界大小分开，比如左边大右边小
     *3、平均时间复杂度是O（nlogn），最坏情况下的时间复杂度是O（n^2）
     */
    public static  void quickSort(int[] nums){

        //挖坑法

        //指针交换法

    }

    public static  void quickSort(int[] nums,int left,int right){

        if(left>=right)
            return;
        //得到基准位置
        /*//挖坑法
        int pivotIndex =partition1(nums,left,right);*/
        //指针交换法
        int pivotIndex =partition2(nums,left,right);

        //用分治法递归数列的两部分
        quickSort(nums,left,pivotIndex-1);
        quickSort(nums,pivotIndex+1,right);

    }

    private static int partition1(int[] nums,int left,int right){
        //取第一个位置的元素作为基准元素
        int pivot = nums[left];
        //坑的位置
        int index = left;
        //大循环在左右指针重合或者交错时结束
        while(right>=left){
            //right指针从右向左进行比较
            while (right>=left){
                if(nums[right]<pivot){
                    nums[left]=nums[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            //left指针从左向右进行比较
            while(right>=left){
                if(nums[left]>pivot){
                    nums[right]=nums[left];
                    index=left;
                    right--;
                    break;
                }
                left++;
            }
        }
        nums[index]=pivot;
        return index;
    }

    private static int partition2(int[] nums,int startIndex, int endIndex){
        //取第一个位置的元素作为基准元素
        int pivot = nums[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left!=right){
            //控制right指针比较并左移
            while (left < right && nums[right]>pivot)
                right--;

            //控制right指针比较并右移
            while (left < right && nums[left]<=pivot)
                left++;

            //交换left和right指向的元素
            if(left < right){
                int p = nums[left];
                nums[left]=nums[right];
                nums[right]=p;
            }
        }

        //pivot和指针重合点交换
        int p = nums[left];
        nums[left] = nums[startIndex];
        nums[startIndex] = p;
        return left;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 6, 5, 3, 2, 8, 1,15,12,14};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
