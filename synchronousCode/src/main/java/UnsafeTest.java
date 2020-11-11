import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author Tiger
 * @date 2020/11/11 22:28
 */
public class UnsafeTest {
    public static void main(String[] args) throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        User user = (User) unsafe.allocateInstance(User.class);
        System.out.println(user.toString());
    }
}

@ToString
@Getter
@AllArgsConstructor
class User {
    private String name;

    public User() {
        this.name = "tiger";
    }
}
