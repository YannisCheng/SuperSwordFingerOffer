package base.design_patterns.proxy.dynamic_proxy;

import base.design_patterns.proxy.People;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * DynamicProxy 动态代理类
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/7/22 11:40
 */
public class DynamicProxy implements InvocationHandler {

    /**
     * 被代理对象
     */
    private final People object;

    public DynamicProxy(People object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName());
        System.out.println(this.object.getClass().getName());
        //在真实的对象执行之前我们可以添加自己的操作
        System.out.println("before invoke。。。");
        System.out.println("方法名："+method.getName());
        Object invoke = method.invoke(object, args);
        //在真实的对象执行之后我们可以添加自己的操作
        System.out.println("after invoke。。。");
        return invoke;
    }
}
