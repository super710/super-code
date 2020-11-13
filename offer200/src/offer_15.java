/**
 * @Author Jinshihong
 * @Date 2020/11/13 9:28
 * @Version 1.0
 *
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class offer_15 {

    public static void main(String[] args) {
        offer_15 o=new offer_15();
        System.out.println(o.hammingWeight(12));
    }

    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            //&1   可以知道最右边的位  是多少
           if ((n&1)==1) count++;
           //  >>>无符号右移  高位补0  /  << 左移  低位补0  /   >>  右移  正：高位补0  负：高位补1
           n>>>=1;
        }
        return count;
    }

}
