package algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/16
 */
public class ReverseInteger {

    /**
     * 7. 整数反转
     */

    /**
     * 转化为字符串的反转
     */
    public static int reverse(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        char temp;
        for (int i = 0; i < chars.length / 2; ++i) {
            temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        s = new String(chars);
        if (s.contains("-")){
            s = s.replace("-", "");
            s = "-" + s;
        }
        try {
            return Integer.parseInt(s);
        } catch (Exception e){
            return 0;
        }
    }

    /**
     * 使用队列进行反转，先进先出
     */
    public static int reverse1(int x) {
        int y = 0;
        Queue<Integer> nums = new ArrayDeque<>();
        while (x != 0){
            nums.add(x % 10);
            x = x / 10;
        }
        while (!nums.isEmpty()){
            Integer poll = nums.poll();
            if (y > Integer.MAX_VALUE/10 || (y== Integer.MAX_VALUE / 10 && poll > 7)) return 0;
            if (y < Integer.MIN_VALUE/10 || (y == Integer.MIN_VALUE / 10 && poll < -8)) return 0;
            y = y * 10 + poll;
        }
        return y;
    }

    /**
     * 直接反转
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        int y = 0;
        while (x != 0){
            int poll = x % 10;
            x = x / 10;
            if (y > Integer.MAX_VALUE/10 || (y== Integer.MAX_VALUE / 10 && poll > 7)) return 0;
            if (y < Integer.MIN_VALUE/10 || (y == Integer.MIN_VALUE / 10 && poll < -8)) return 0;
            y = y * 10 + poll;
        }
        return y;
    }
    public static void main(String[] args) {

        System.out.println(reverse(153423646));
        System.out.println(reverse1(153423646));
        System.out.println(reverse2(153423646));
    }
}
