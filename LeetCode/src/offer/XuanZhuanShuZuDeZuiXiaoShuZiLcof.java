package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/16
 */
public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {

    /**
     * 剑指 Offer 11. 旋转数组的最小数字
     */

    /**
     * 暴力法，遍历数组发现前一个大于后一个数，直接输出后面的数，如果没有则输出第一个数
     */

    public static int minArray(int[] numbers) {

        for (int i = 0; i < numbers.length - 1; ++i) {
            if (numbers[i] > numbers[i + 1]){
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    /**
     * 二分查找
     */
    public static int minArray1(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        int temp;
        while (low < high){

            temp = (low + high) / 2;
            if (numbers[temp] < numbers[high]){
                high = temp;
            } else if (numbers[temp] > numbers[high]) {
                low = temp + 1;
            } else {
                high--;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {

        System.out.println(minArray(new int[]{3,3,1,3}));
        System.out.println(minArray1(new int[]{3,3,1,3}));
    }
}
