package 字符串;

import java.util.Arrays;

/**
 * @author Tiger
 * @date 2020/11/27 8:47
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
public class _剑指_Offer_58_I_翻转单词顺序 {
    public static String reverseWords(String s) {
        //首先消除空格
        char[] chars = s.toCharArray();
        int len;
        int cur = 0;
        //前面是否是空格
        boolean space = true;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c != ' ') {
                chars[cur++] = c;
                space = false;
            } else if (!space) {
                chars[cur++] = c;
                space = true;
            }
        }
        len = space ? cur - 1 : cur;
        if (len<=0){
            return null;
        }

        reverse(chars, 0, len - 1);

        int flag = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {
                reverse(chars, flag, i - 1);
                flag = i + 1;
            }
        }
        reverse(chars, flag, len - 1);
        return new String(chars, 0, len);
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[right];
            chars[right] = chars[left];
            chars[left] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the world!"));
    }
}
