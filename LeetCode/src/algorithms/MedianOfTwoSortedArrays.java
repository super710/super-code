package algorithms;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/12
 */
public class MedianOfTwoSortedArrays {

    /**
     * 4. 寻找两个正序数组的中位数
     */

    /**
     * 合并两个数组，数组长度为奇数时，取中间的数作为中位数，为偶数时，取中间两个数的平均值
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int size1 = nums1.length;
        int size2 = nums2.length;
        int size = size1 + size2;
        int[] nums = new int[size1 + size2];
        int j = 0, k = 0;
        for (int i = 0; i < size1; ++i) {
            if (j >= size2) {
                nums[k++] = nums1[i];
            } else if (nums1[i] <= nums2[j]) {
                nums[k++] = nums1[i];
            } else {
                nums[k++] = nums2[j++];
                i--;
            }
        }
        if (j < size2) {
            for(; j < size2; ++j){
                nums[k++] = nums2[j];
            }
        }
        if (size % 2 == 0){
            size /= 2;
            return (nums[size] + nums[size - 1]) / 2.0;
        }
        return nums[size/2];
    }

    public static void main(String[] args) {

        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2,4}));
    }
}
