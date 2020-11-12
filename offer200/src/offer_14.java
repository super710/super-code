/**
 * @Author Jinshihong
 * @Date 2020/11/12 9:55
 * @Version 1.0
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class offer_14 {

    public static void main(String[] args) {
        offer_14 o=new offer_14();
        int res=o.cuttingRope2(127);
        System.out.println(res);
    }

    public int cuttingRope(int n) {
        if (n<=3) return n-1;
        int m=n/3;
        int k=n%3;
        int sum=0;
        if (k==2) sum=(int)Math.pow(3,m)*k;
        else if(k==1) sum=(int)Math.pow(3,m-1)*4;
        else sum=sum=(int)Math.pow(3,m);

        return sum;
    }
     public long remainder(int x,int a,int p){
        long res=1;
        for(int i=0;i<a;i++){
            res=(res*x)%p;
        }
        return res;

     }

//        1.当 n≤3 时，按照规则应不切分，但由于题目要求必须剪成 m>1段，因此必须剪出一段长度为 1的绳子，即返回 n - 1 。
//        2.当 n>3 时，求 n 除以 3的 整数部分 a和 余数部分 b （即 n = 3a + b ），并分为以下三种情况（设求余操作符号为 "⊙" ）：
//             当 b = 0 时，直接返回 3^a ⊙ 1000000007
//             当 b = 1时，要将一个 1 + 3转换为 2+2，因此返回 (3^{a-1}* 4)⊙ 1000000007
//             当 b = 2时，返回 (3^a *2) ⊙1000000007


    public int cuttingRope2(int n) {
        if (n<=3) return n-1;
        int x=n/3;
        int a=n%3;
        int p=1000000007;
        long sum=0;
        if (a==2) sum=(remainder(3,x,p)*2)%p;
        else if(a==1) sum=(remainder(3,x-1,p)*4)%p;
        else sum=remainder(3,x,p);

        return (int)sum;
    }


}
