package 剑指Offer;

/**
 * @author Tiger
 * @date 2020/11/30 9:41
 */
public class 二进制中1的个数 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
