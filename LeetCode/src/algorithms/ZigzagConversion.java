package algorithms;

import java.util.ArrayList;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/16
 */
public class ZigzagConversion {

    /**
     *  6. Z 字形变换
     */

    /**
     * 二维数组，按照Z字形输入进二维数组，按行进行输出
     */
    public static String convert(String s, int numRows) {
        int length = s.length();
        if (numRows < 2){
            return s;
        }
        char[][] chars = new char[numRows][length];
        for (int i = 0, k = 0; i < length; i++) {
            for (int j = 0; j < numRows && k < length; j++) {
                if (i % (numRows - 1) == 0){
                    chars[j][i] = s.charAt(k++);
                } else if ((i + j) % (numRows - 1) == 0){
                    chars[j][i] = s.charAt(k++);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < length; j++) {
                if (chars[i][j] != 0){
                    builder.append(chars[i][j]);
                }
            }
        }
        return builder.toString();
    }

    /**
     * 寻找字符串输出规律，原字符串的对应的行号是12321232123···等，在第一行和最后一行变换输出方向，将每一行的
     * 字符进行拼接，最后将所有行进行拼接输出，时间复杂度为o(n)
     */
    public static String convert1(String s, int numRows) {
        if (numRows < 2){
            return s;
        }
        ArrayList<StringBuilder> builders = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            builders.add(new StringBuilder());
        }
        boolean flag = false;
        for (int i = 0, num = 0; i < s.length(); i++) {
            builders.get(num).append(s.charAt(i));
            if (num == 0 || num == numRows - 1){
                flag = !flag;
            }
            num += flag ? 1 : -1;
        }
        StringBuilder builder = new StringBuilder();
        for (StringBuilder builder1 : builders) {
            builder.append(builder1);
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        System.out.println(convert("LEETCODEISHIRING", 3));
        System.out.println(convert1("LEETCODEISHIRING", 3));
    }
}
