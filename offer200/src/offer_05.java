/**
 * @Author Jinshihong
 * @Date 2020/11/9 9:46
 * @Version 1.0
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class offer_05 {


    public static void main(String[] args) {


    }


    public String replaceSpace(String s) {
        StringBuffer str=new StringBuffer() ;
        if (s.length()==0) return str.toString();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' '){
                str.append("%20");
            }else {
                char ss=s.charAt(i);
                str.append(ss);
            }
        }
        return str.toString();
    }


    public String replaceSpace2(String s) {
        char[] array=new char[s.length()*3];
        int index=0;
        for (char c:s.toCharArray()){
            if (c!=' ')
                array[index++]=c;
            else{
                array[index++]='%';
                array[index++]='2';
                array[index++]='0';
            }


        }
//        不能使用 array.toString()  字符数组直接使用，返回的是字符数组的地址
        return new String(array,0,index);

    }


}
