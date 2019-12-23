import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestMain implements IPerson {

    public static void main(String[] args) {
        System.out.println("Hello world");

        TestMain testMain = new TestMain();

        IPerson testMainProxy = (IPerson) Proxy.newProxyInstance(TestMain.class.getClassLoader(), TestMain.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("eat")) {
                    System.out.println("我饿了");
                    return method.invoke(testMain, args);
                }

                return method.invoke(testMain, args);
            }
        });

        testMainProxy.eat();
        testMainProxy.sleep();


        String name = getInstance(String.class);
    }

    @Override
    public void eat() {
        System.out.println("我在吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("我要睡觉");
    }

    public <T> T getName(T name) {
        return name;
    }


    public static <T> T getInstance(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

interface IPerson {
    void eat();
    void sleep();
}