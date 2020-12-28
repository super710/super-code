package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序：
 * 区间跨度 = （最大值-最小值）/ （桶的数量 - 1)
 */
public class BucketSort {


    private static double[] bucketSort(double[] nums){

        double min = nums[0];
        double max = nums[0];
        for (double num : nums) {
            if(num<min)
                min = num;

            if(num>max)
                max =num;
        }

        double d = max -min;

        //初始化桶
        int bucketNum = nums.length;

        ArrayList<LinkedList<Double>> bucketlist = new ArrayList<>();
        for(int i =0;i<bucketNum;i++){
            bucketlist.add(new LinkedList<Double>());
        }

        //遍历原始数据，将每个元素放入桶中
        for(int i =0;i<nums.length;i++){
            int num = (int) ((nums[i] - min) * (bucketNum - 1) / d);
            bucketlist.get(num).add(nums[i]);
        }

        //对每个桶内进行排序
        for(int i =0;i<bucketlist.size();i++){
            Collections.sort(bucketlist.get(i));
            //Collections.sort底层采用的是归并排序或Timsort，
            // 可以简单地把它们当做是一种时间复杂度 O（nlogn）的排序。
        }

        //5.输出全部元素
        double[] sortedArray = new double[nums.length];
        int index = 0;
        for (LinkedList<Double> list : bucketlist) {
            for (double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;

    }
    public static void main(String[] args) {
        double[] array = new double[]{4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}

