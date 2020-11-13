/**
 * @Author Jinshihong
 * @Date 2020/11/13 10:05
 * @Version 1.0
 *
 *
 *
 *实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 *
 *
 *
 */
public class offer_16 {

    public static void main(String[] args) {
        offer_16 o= new offer_16();
        System.out.println(o.myPow(1,2147483647));
    }


    //x^n  ->  x^b
    public double myPow(double x, int n) {
        if(x==0) return 0;
        double res=1;
        long b=n;
        if (b<0)
        {
            b=-b;  //-long才不不会报错   int范围:  -2147483648 ~ 2147483647    -2147483648转正 int无法存储
            x=1/x;
        }

        //b为奇数   分一个x出去   然后算x=x^2  然后把幂降一倍
        /* 计算  3^5
            3^5*(1) —>  9^2*(1*3)  ->   81^1*(1*3) -> 6561^0*(1*3*81)    =   1*3*81
         */
        while(b>0){
            if ((b&1)==1) res*=x;
            x*=x;
            b>>=1;
        }


        return res;

    }

}
