/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 思路：10的n次方减一
 */
public class PrintNumbers {

    public static int[] printNumbers(int n) {
            int length = (int) (Math.pow(10,n)-1);
            int[] numbers = new int[length];
            for(int i =0;i<length;i++)
                numbers[i]=i+1;

            return numbers;
    }

    public static void main(String[] args) {

        int[] numbers = printNumbers(2);
        for (int number : numbers) {
            System.out.printf("%d",number);
        }
    }
}
