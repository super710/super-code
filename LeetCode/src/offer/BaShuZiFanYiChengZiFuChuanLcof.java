package offer;

/**
 * @Author cy
 * @Description
 * @Date 2021/3/2
 */
public class BaShuZiFanYiChengZiFuChuanLcof {

    /**
     * 剑指 Offer 46. 把数字翻译成字符串
     */

    /**
     * 动态规划，以i结尾的，只和i - 1和i - 2有关
     */

    public static int translateNum(int num) {
        int p = 1, q = 0, r = 1;
        String str = String.valueOf(num);
        for (int i = 1; i < str.length(); i++) {
            q = p;
            p = r;
            if ((str.substring(i - 1, i + 1).compareTo("10") >= 0 && (str.substring(i - 1, i + 1).compareTo("25") <= 0))){
                r = p + q;
            } else {
                r = p;
            }
        }
        return r;
    }

    public static void main(String[] args) {

        System.out.println(translateNum(11258));
    }
}
