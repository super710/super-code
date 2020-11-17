import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
class JDKDynamicProxy implements InvocationHandler {

    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * 获取被代理接口实例对象
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Do something before");
        Object result = method.invoke(target, args);
        System.out.println("Do something after");
        return result;
    }
}