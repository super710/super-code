/**
 * @Author Jinshihong
 * @Date 2020/11/9 20:48
 * @Version 1.0
 */
public class offer_10 {

    public static void main(String[] args) {
        offer_10 o=new offer_10();
        o.fib(3);
    }

    public int fib(int n) {
        int f1=1,f0=0,sum=0;
        if (n==0) return 0;
        if (n==1) return 1;
        for (int i=1;i<=n-1;i++){
            sum=(f0+f1)%1000000007;
            f0=f1;
            f1=sum;
        }
        return sum;

    }
}
