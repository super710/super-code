import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.io.*;
import java.lang.reflect.Field;

/**
 * @author Tiger
 * @date 2020/11/12 9:00
 */
@Slf4j(topic = "c.ClazzInstance")
public class ClazzInstance {
    //类的实例化方式
    public static void main(String[] args) throws Exception {
        //1、通过构造方法
        SuperClass constrcutSuperClass = new SuperClass();
        //2、通过Class实例化
        SuperClass clazzSuperClass = SuperClass.class.newInstance();
        //3、反射
        SuperClass reflectSuperClass = SuperClass.class.getDeclaredConstructor().newInstance();
        //4、通过克隆
        SuperClass cloneSuperClass = (SuperClass) constrcutSuperClass.clone();
        //5、通过反序列化
        SuperClass deSuperClass = deSerialize(constrcutSuperClass);
        //6、通过Unsafe实例化一个类
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        SuperClass unsafeSuperClass = (SuperClass) unsafe.allocateInstance(SuperClass.class);

        log.debug("constrcutSuperClass: {}", constrcutSuperClass.toString());
        log.debug("clazzSuperClass: {}", clazzSuperClass.toString());
        log.debug("reflectSuperClass: {}", reflectSuperClass.toString());
        log.debug("cloneSuperClass: {}", cloneSuperClass.toString());
        log.debug("deSuperClass: {}", deSuperClass.toString());
        log.debug("unsafeSuperClass: {}", unsafeSuperClass.toString());


    }

    private static SuperClass deSerialize(SuperClass superClass) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\super-code\\synchronousCode\\src\\main\\java\\Object.txt"));
        oos.writeObject(superClass);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\super-code\\synchronousCode\\src\\main\\java\\Object.txt"));
        SuperClass readObject = (SuperClass) ois.readObject();
        ois.close();
        return readObject;
    }

}

@Data
class SuperClass implements Cloneable, Serializable {
    private String address;
    private Integer stuCount;

    public SuperClass() {
        this.address = "cqupt";
        this.stuCount = 40;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
