package Sort;

import java.util.Arrays;

public class Selection {


    //选择排序
    public static void selectionSort(int[] array) {
       //每一次循环把最大的元素放到最前面，只用遍历n-1次
        for(int i =0;i<array.length-1;i++){
            int maxIndex =i;
            for(int j =i+1;j<array.length;j++){
                //找出最大元素的坐标
                maxIndex = array[j] > array[maxIndex] ? j : maxIndex;
            }
            int temp = array[i];
            array[i]=array[maxIndex];
            array[maxIndex]=temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8, 30, 50, 1, 33, 24, 5, -4, 7, 0};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 缺点是 当数组中元素有相同时，有可能会打乱顺序（值相同的顺序）
     *
     */
}
