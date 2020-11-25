package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/25
 */
public class BiaoShiShuZhiDeZiFuChuanLcof {

    /**
     * 剑指 Offer 20. 表示数值的字符串
     */

    /**
     * 直接try catch，无法转为Double的在排除掉结尾有D,d,f的
     */

    public static boolean isNumber(String s) {
        try {
            double v = Double.parseDouble(s);
        } catch (Exception e){
            return false;
        }
        char c = s.charAt(s.length()-1);
        return (c >= '0' && c <= '9') || c == '.';
    }

    public static void main(String[] args) {

        System.out.println(isNumber("1 "));
    }
}
