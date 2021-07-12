package pattern.proxytotal.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ClientTest {
    public static void main(String[] args) {
        //需要代理的类（真实对象）
        Subject realSubject=new RealSubject();
        //我们要代理那个类，就将该对象传递进去，最后通过该真实对象来调用其方法
        InvocationHandler handler=new DynamicProxy(realSubject);
        /*
        通过proxy的newproxyInstance方法来创建我们的代理对象
        1.handler.getclass.getclassloader()使用handler类的classloader对象来加载我们的代理对象
        2.realSubject.getClass().getInterfaces()这里为代理对象提供的接口是真实对象所实行的接口，表示要代理的是该真实对象，这样
        就可以调用者组接口中的方法
        3.handler，我们这里将这个代理对象关联到上方的invocationHandler
         */
        Subject subject= (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),realSubject.getClass().getInterfaces(),handler);
        System.out.println(subject.getClass().getName());
        subject.rent();
        subject.Hello(" world!");
    }
}
