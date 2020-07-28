import com.whz.javaee.SayHello;

import java.lang.reflect.InvocationTargetException;

public class MainTest {
    public static void main(String[] args) {
        try {
            SayHello sayHello1 = (SayHello) Class.forName("com.whz.javaee.SayHello").newInstance();
            sayHello1.sayHello();

            SayHello sayHello2 = (SayHello) Class.forName("com.whz.javaee.SayHello").getConstructor(String.class).newInstance("xiaowang");
            sayHello2.sayHello();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
