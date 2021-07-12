package pattern.proxytotal.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    //需要被代理的类
    private Object subject;

    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在代理真实对象前增加自己的操作
        System.out.println("before rent house");
        System.out.println("methond:"+method);
        //当代理对象调用真实对象方法之时，会自动跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(subject,args);
        //代理真实对象之后增加自己的操作
        System.out.println("after the house");
        return null;
    }
}
