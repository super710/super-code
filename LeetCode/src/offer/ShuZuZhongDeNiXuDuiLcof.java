package offer;

/**
 * @Author cy
 * @Description
 * @Date 2021/3/21
 */
public class ShuZuZhongDeNiXuDuiLcof {

    /**
     * 剑指 Offer 51. 数组中的逆序对
     */

    /**
     * 利用归并排序，每次得到左边数组里的每个数据在右边数组中有几个小于它的，然后对次数
     * 求和，最后将所有的加起来
     */

    public static int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1, temp);
    }

    public static int mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start < end){
            int mid = (start + end) / 2;
            int i = mergeSort(nums, start, mid, temp);
            int j = mergeSort(nums, mid + 1, end, temp);
            int merge = merge(nums, start, mid, end, temp);
            return i + j + merge;
        } else {
            return 0;
        }
    }

    public static int merge(int[] nums, int start, int mid, int end, int[] temp) {
        int k = 0, count = 0;
        int i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]){
                count += end - j + 1;
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid){
            temp[k++] = nums[i++];
        }
        while (j <= end){
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, start, k);
        return count;
    }


    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{7, 5, 6, 4}));
    }
}
