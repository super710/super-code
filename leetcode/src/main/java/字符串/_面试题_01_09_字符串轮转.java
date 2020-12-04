package 字符串;

/**
 * @author Tiger
 * @date 2020/11/26 9:14
 */
public class _面试题_01_09_字符串轮转 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer(s1);
        if (stringBuffer.append(s1).toString().contains(s2)) {
            return true;
        }
//        return false;
        return s1.length() == s2.length() && (s1+s2).contains(s2)==true;
    }
}
