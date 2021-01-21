package offer;

/**
 * @Author cy
 * @Description
 * @Date 2021/1/20
 */
public class ShuZiCuLieZhongMouYiWeiDeShuZiLcof {

    /**
     * 剑指 Offer 44. 数字序列中某一位的数字
     */

    /**
     * 利用数学规律，1-9有9个，10-99有90个，100-999有900个……，先判断是几位的第几个
     * 数字，再判断是这个数的第几位，进行输出
     */

    public static int findNthDigit(int n) {
        int digit = 1;
        long count = 9;
        long num = 1;
        while (n > count){
            n -= count;
            digit += 1;
            num *= 10;
            count = num * digit * 9;
        }
        num += (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(10000));
    }
}
