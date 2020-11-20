package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/20
 */
public class ErJinZhiZhong1DeGeShuLcof {

    /**
     * 剑指 Offer 15. 二进制中1的个数
     */

    /**
     * 对于二进制数，借鉴对n取模时，可以&n-1的思想，将只n = n&n-1，即
     * 00001000 & 00000111，将会消掉n最右边的一个1，循环遍历直到n = 0，
     * 此时输出1的个数
     *
     * Integer.bitCount()可以直接运算，源码中使用移位操作实现的计算，0ms实现
     */

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int i = 0;
        while (n != 0){
            i++;
            n = n & n - 1;
        }
        return i;
    }

    public static void main(String[] args) {

       System.out.println(hammingWeight(11));
    }
}