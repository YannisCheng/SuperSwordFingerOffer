package base.design_patterns.proxy.dynamic_proxy;

import base.design_patterns.proxy.People;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * DynamicProxy更名为InvocationImpl
 *
 * 这个类存在的作用就是：
 * 1. 实现了InvocationHandler接口的invoke()；
 * 2. 将接口InvocationHandler的实现类对象作为 Proxy.newProxyInstance(）的参数。
 *
 * 简而言之：在接口的方法中调用“被代理类”自身的方法。
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/7/22 11:40
 */
public class InvocationImpl implements InvocationHandler {

    /**
     * 被代理对象
     */
    private final People object;

    public InvocationImpl(People object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName());
        System.out.println(this.object.getClass().getName());
        //在真实的对象的 某一个方法 执行之前 我们可以添加自己的操作
        System.out.println("before invoke。。。");
        System.out.println("方法名："+method.getName());
        Object invoke = method.invoke(object, args);
        //在真实的对象的 某一个方法 执行之后我们可以添加自己的操作
        System.out.println("after invoke。。。");
        return invoke;
    }
}
