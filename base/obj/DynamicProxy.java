package base.obj;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    public static void main(String[] args) throws Exception {
        InvocationHandler handler = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.printf("[method] == %s \n", method);
                if (method.getName().equals("Hello")) {
                    System.out.printf("hello %s", args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[] {Hello.class}, handler);
        hello.morning("Bob");
    }
}

interface Hello {
    void morning(String name);
    void morning1(String name);
}