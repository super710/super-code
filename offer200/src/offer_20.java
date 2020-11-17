/**
 * @Author Jinshihong
 * @Date 2020/11/17 10:26
 * @Version 1.0
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * 假设字符串为A.BeC或A.BEC, 也就是整数部分为A，小数部分为B，指数部分为C，按顺序判断是否包含这三部分。
 *
 * 在字符串后添加结束标志
 * 使用全局index遍历字符串
 * scanInteger扫描有符号整数，用来匹配A和C部分
 * scanUnsignedInteger扫描无符号整数，用来匹配B部分
 * 注意：输入用例中字符串首尾空格也合法，例如“空格1.2空格”是返回true的。所以需要跳过首尾的空格。
 *
 *
 */
public class offer_20 {

    private int index = 0;//全局索引
    private boolean scanUnsignedInteger(String str) {
        //是否包含无符号数
        int before = index;
        while(str.charAt(index) >= '0' && str.charAt(index) <= '9')
            index++;
        return index > before;
    }
    private boolean scanInteger(String str) {
        //是否包含有符号数
        if(str.charAt(index) == '+' || str.charAt(index) == '-')
            index++;
        return scanUnsignedInteger(str);
    }
    public boolean isNumber(String s) {
        //空字符串
        if(s == null || s.length() == 0)
            return false;


        s=s.trim();
        //添加结束标志
        s = s + '|';
        //跳过首部的空格
//        while(s.charAt(index) == ' ')
//            index++;


        boolean numeric = scanInteger(s); //是否包含整数部分

        if(s.charAt(index) == '.') {
            index++;
            //有小数点，处理小数部分
            //小数点两边只要有一边有数字就可以，所以用||，
            //注意scanUnsignedInteger要在前面，否则不会进
            numeric = scanUnsignedInteger(s) || numeric;
            if (numeric==false) return false;
        }
        if((s.charAt(index) == 'E' || s.charAt(index) == 'e')) {
            index++;
            //指数部分
            //e或E的两边都要有数字，所以用&&
            numeric = numeric && scanInteger(s);
            if (numeric==false) return false;
        }
        //跳过尾部空格
//        while(s.charAt(index) == ' ')
//            index++;
        return numeric && s.charAt(index) == '|' ;
    }
}
