import java.util.ArrayList;
import java.util.List;

/**
 * @Author Jinshihong
 * @Date 2020/11/13 11:18
 * @Version 1.0
 */
public class offer_17 {

    public static void main(String[] args) {
        offer_17 o=new offer_17();
        o.printNumbers(2);
    }

    public int[] printNumbers(int n) {
            int end=(int)Math.pow(10,n)-1;
            int arr[]=new int[end];
            for (int i=0;i<end;i++){
                arr[i]=i+1;
            }
            return arr;


    }

}
