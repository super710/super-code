package 数组;

import java.util.Arrays;

/**
 * @author Tiger
 * @date 2020/11/18 9:26
 * https://leetcode-cn.com/problems/reverse-string/
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 */
public class _344_反转字符串 {
    public static void reverseString1(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        reverseString2(new char[]{'h', 'e', 'l'});
    }

    public static void reverseString2(char[] s) {
        reverse(0, s.length - 1, s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverse(int left, int right, char[] chars) {
        if (right <= left) {
            return;
        }
        char temp = chars[right];
        chars[right] = chars[left];
        chars[left] = temp;
        reverse(++left, --right, chars);
    }
}
