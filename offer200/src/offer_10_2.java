/**
 * @Author Jinshihong
 * @Date 2020/11/10 9:29
 * @Version 1.0
 */
public class offer_10_2 {





    public int numWays(int n) {
        int f1=1,f2=2,sum=0;
        if (n==0) return 1;
        if (n==1) return 1;
        if (n==2) return 2;
        for (int i=3;i<=n;i++){
            sum=(f1+f2)%1000000007;
            f1=f2;
            f2=sum;
        }
        return sum;

    }




}
