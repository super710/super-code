package Tree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *  
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 *示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true

 */
public class VerifyPostorder {

    /**
     * 思路：后序遍历，最后一个节点是根节点，从左往右遍历第一个比根节点大的节点，然后划分为左子树和右子树两个区间
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }

    //递归判断数组是否是搜索子树
    public boolean recur(int[] num,int i,int j){

        if(i>=j)
            return true;

        //根节点
        int root = num[j];

        //临界点
        int mid=i;
        while (num[mid]<num[j])
            mid++;
        int temp = mid;

        //因为postorder[mid]前面的值都是比根节点root小的，
        //我们还需要确定postorder[mid]后面的值都要比根节点root大，
        //如果后面有比根节点小的直接返回false

        while(temp<j){
            if(num[temp++]<root)
                return false;
        }



        return recur(num,i,mid-1)&&recur(num,mid,j-1);
    }
}
