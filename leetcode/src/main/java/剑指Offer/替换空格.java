package 剑指Offer;

import java.util.Arrays;

/**
 * @author Tiger
 * @date 2020/11/28 15:21
 */
public class 替换空格 {
//    public String replaceSpace(String s) {
//        while (s.contains(" ")) {
//            s = s.replace(" ", "%20");
//        }
//        return s;
//    }

    public String replaceSpace(String s) {
        int length = s.length();
        char[] chars = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = c;
            }
        }
        return new String(chars, 0, size);
    }
}
