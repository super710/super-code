package offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author cy
 * @Description
 * @Date 2021/3/1
 */
public class BaShuZuPaiChengZuiXiaoDeShuLcof {

    /**
     * 剑指 Offer 45. 把数组排成最小的数
     */

    /**
     * 定义一种排序规则，即字符串 X + Y < Y + X ==> X < Y
     */

    public static String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
//        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        fastSort(strings, 0, nums.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    /**
     * 自定义快速排序
     */
    public static void fastSort(String[] strs, int left, int right){
        if (left >= right){
            return;
        }
        String pio = strs[left];
        int i = left;
        int j = right;
        while (i < j){
            while (i < j && (pio + strs[j]).compareTo(strs[j] + pio) < 0){
                j--;
            }
            while (i < j && (pio + strs[i]).compareTo(strs[i] + pio) >= 0){
                i++;
            }
            String temp = strs[j];
            strs[j] = strs[i];
            strs[i] = temp;
        }
        strs[left] = strs[j];
        strs[j] = pio;
        fastSort(strs, left, j - 1);
        fastSort(strs, j + 1, right);
    }

    public static void main(String[] args) {
        int[] ints = {2, 1};
//        int[] ints = {5, 6, 3, 2, 7};
        System.out.println(minNumber(ints));
//        fastSort(ints, 0, ints.length - 1);
        System.out.println(ints);
    }
}
