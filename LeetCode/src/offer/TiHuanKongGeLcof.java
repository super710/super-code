package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/11
 */
public class TiHuanKongGeLcof {

    /**
     * 剑指 Offer 05. 替换空格
     */

    /**
     * 遍历字符串，利用StringBuilder的特性，将遍历的字符拼接起来，遇到空格时替换成"%20"
     */
    public static String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for(char a : s.toCharArray()){
            if(a == ' '){
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(a);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        System.out.println(replaceSpace("We are happy."));
    }
}
