package offer;

/**
 * @Author cy
 * @Description
 * @Date 2021/1/19
 */
public class OneNZhengShuZhong1chuXianDeCiShuLcof {

    /**
     * 剑指 Offer 43. 1～n 整数中 1 出现的次数
     */

    /**
     * 根据题解进行理解，类比于密码锁，固定某一位，其他位置有多少种变化
     */

    public static int countDigitOne(int n) {
        int cur = n % 10;
        int digit = 1;
        int low = 0;
        int high = n / 10;
        int count = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                count += high * digit;
            } else if (cur == 1) {
                count += high * digit + low + 1;
            } else {
                count += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
    }
}
