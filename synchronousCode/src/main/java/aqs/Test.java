package aqs;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tiger
 * @date 2020/11/16 22:16
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.add(2);

        OutputStream outputStream = new FileOutputStream(new File("E:\\super-code\\synchronousCode\\src\\main\\java\\aqs\\array.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(integers1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\super-code\\synchronousCode\\src\\main\\java\\aqs\\array.txt"));
        ArrayList o = ((ArrayList) ois.readObject());
        System.out.println(o.size());

    }
}
