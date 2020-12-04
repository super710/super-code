package 剑指Offer;

/**
 * @author Tiger
 * @date 2020/11/30 8:52
 */
//输入：[3,4,5,1,2]
//输出：1

public class 旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        int right = numbers.length - 1;
        int left = 0;
        while (right > 0 && numbers[right] == numbers[left]) {
            right--;
        }
        if (numbers[right] >= numbers[left]) {
            return numbers[0];
        }
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[0]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return numbers[left];
    }
}
