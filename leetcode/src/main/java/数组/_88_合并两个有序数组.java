package 数组;

import java.util.Arrays;

/**
 * @author Tiger
 * @date 2020/11/15 10:30
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class _88_合并两个有序数组 {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = m - 1;
        int nums2Index = n - 1;
        int cur = nums1.length - 1;
        while (nums2Index >= 0 && nums1Index >= 0) {
            int num2 = nums2[nums2Index];
            int num1 = nums1[nums1Index];
            if (num2 >= num1) {
                nums1[cur] = num2;
                nums2Index--;
            } else {
                nums1[cur] = num1;
                nums1Index--;
            }
            cur--;
        }
        if (nums1Index < 0) {
            for (int index = nums2Index; index >= 0; index--) {
                nums1[cur--] = nums2[index];
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = m - 1;
        int nums2Index = n - 1;
        int cur = nums1.length - 1;
        while (nums2Index >= 0) {
            if (nums1Index >= 0 && nums2[nums2Index] < nums1[nums1Index]) {
                nums1[cur--] = nums1[nums1Index--];
            } else {
                nums1[cur--] = nums2[nums2Index--];
            }
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int num1 = m - 1;
        int num2 = n - 1;
        int cur = nums1.length - 1;
        while (0 <= num2) {
            if (num1 >= 0 && nums1[num1] > nums2[num2]) {
                nums1[cur--] = nums1[num1--];
            } else {
                nums1[cur--] = nums2[num2--];
            }
        }
    }

}
