package Sort;

import java.util.Arrays;

/**
 * 希尔排序，不稳定排序
 */
public class ShellSort {
    public static void shellSortBySelf(int[] array, int n) {
        //希尔排序的增量
        int d = array.length;
        while (d > 1) {
            //使用希尔增量的方式，即每次折半
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i = i + d) {
                    int temp = array[i];
                    int j;
                    //对分组分别进行插入排序
                    for (j = i - d; j >= 0 && array[j] > temp; j = j - d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }


    public static void shellSortBySelf1(int[] array, int n) {
        int d =n ;//间隔
        int pivot, j;
        while (d>1){
            d/=2;
            for(int i =0;i<n-d;i++){
                if(array[i]>array[i+d]){
                    int temp =array[i];
                    array[i]=array[i+d];
                    array[i+d]=temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }

    }
    public static void main(String[] args) {

        int[] array = {5, 3, 9, 12, 6, 1, 7, 2, 4, 11, 8, 10};
        int[] array1 = {5, 3, 9, 12, 6, 1, 7, 2, 4, 11, 8, 10};

        shellSortBySelf(array,array.length);
        System.out.println("--------");
        shellSortBySelf1(array1,array1.length);
        System.out.println(Arrays.toString(array));
    }
}
