package Sort;

import java.util.Arrays;

/**
 * 题目：数组里有20个随机整数,取值范围从0到10,
 * 要求用最快的速度把这20个整数从小到大的排序
 *
 * 计数排序：建立一个0-10数组大小为11的数组,遍历原数组,在遍历到数值的下标+1,然后按顺序
 * 打印出计数数组
 */

public class countSort {
    public static int[] countSort(int[] array){

       /* int[] temp = new int[11];

        for (int i : array) {
            temp[i]++;
        }

        int[] res =new int[array.length];
        int j =0;

        for (int i =0;i<temp.length;i++) {
            for(int k=0;k<temp[i];k++){
                res[j++]=i;
            }
        }
        return res;*/
        //1.得到数列的最大值和最小值，并算出差值d
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        //2.创建统计数组并统计对应元素个数
        int[] countArray = new int[d + 1];

        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }
        //3.统计数组做变形，后面的元素等于前面的元素之和
        int sum = 0;
        for (int i = 0; i < countArray.length; i++) {
            sum += countArray[i];
            countArray[i] = sum;
        }
        //4.倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        int[] sortedArray = new int[array.length];
//        for (int i = array.length - 1; i >= 0; i--) {
        for (int i = 0; i <array.length; i++) {
            sortedArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortedArray;

    }

    public static void main(String[] args) {
        int nums[] ={92,95,94,95,93,95,96};
        int[] ints = countSort(nums);
        System.out.println(Arrays.toString(ints));

    }
}
