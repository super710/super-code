package Sort;

import java.util.Arrays;

public class Bubble {
    /**
     * 冒泡排序：
     * 每一轮遍历，都与每一个元素进行比较，时间复杂度是O（N^2）
     */
    private static void sort(int array[]) {
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    //冒泡第一轮排序优化版本
    private static void sort1(int array[]){
        //添加标记位
        int temp = 0;

        for(int i = 0;i<array.length;i++){
            boolean flag=true;//标记位 初始为true
            for (int j =0;j<array.length-i-1;j++){
                //如果有更改，则标记位为false
                if(array[j]>array[j+1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if(flag)
                break;
        }
        
    }


    //冒泡排序第二轮优化版本
    private static void sort3(int array[]) {
        int tmp = 0;
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            //有序标记，每一轮的初始是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                    //把无序数列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        sort1(array);
        System.out.println(Arrays.toString(array));
    }
}
