package 栈_队列;


/**
 * @author Tiger
 * @date 2020/11/24 9:26
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new 栈_队列.TreeNode(nums[0]);
        }
        return findRoot(nums, 0, nums.length);
    }

    private TreeNode findRoot(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int maxIdx = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        return new TreeNode(nums[maxIdx], findRoot(nums, left, maxIdx), findRoot(nums, maxIdx + 1, right));
    }
}
