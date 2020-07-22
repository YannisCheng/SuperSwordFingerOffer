# 设计模式

共23种，可分为： `创建型`、`行为型`、`结构型`3个大类。

 1. 创建型

 - 单例
 - builder建造者（示例：Person.java）
 - 工厂模式
 
 2. 行为型
 
 - 观察者
 
 3. 结构型
 
 - 代理模式
 
 
 ## Builder模式
 
 
 
 ## 代理模式
 
 > 参考：https://www.jianshu.com/p/a0e687e0904f
 
  - 静态代理
  - 动态代理
  
  ## 动态代理- Proxy与InvocationHandler
  
  动态代理类的创建：
  
  ~~~
Proxy.newProxyInstance(loader, interfaces, proxy);
  ~~~

 newProxyInstance(loader, interfaces, proxy)的内部主要实现：
 
~~~
public static Object newProxyInstance(ClassLoader loader,
                                      Class<?>[] interfaces,
                                      InvocationHandler h)throws IllegalArgumentException{
    final Class<?>[] intfs = interfaces.clone();
    // ……

    /*
     * 查找 或 生成 指定的代理类。
     */
    Class<?> cl = getProxyClass0(loader, intfs);

    /*
     * 用指定的 调用处理程序 调用 其构造函数。
     */
    try {
        // getConstructor()作用：获取与指定的 parameterTypes 匹配的公共构造函数的 Constructor 对象。
        // 即constructorParams参数意思为：当前 “构造函数” 的 “形参类型”。
        final Constructor<?> cons = cl.getConstructor(constructorParams);
        // ……
        return cons.newInstance(new Object[]{h});
    } catch (IllegalAccessException|InstantiationException e) {
        ……
    }
}
~~~

通过以上代码可以看出 `Proxy#newProxyInstance()` 种进行了2步操作：

1. 自动创建（由`Proxy.ProxyClassFactory`实现） 具体代理类的 `class文件`：由 `loader` 与 `interfaces` 参数值确定。
2. 由 `class文件` 实例化`指定类型` 的 `具体代理类对象`：通过 `h` 作为 `指明形参参数类型` 的构造函数参数。

因此：
    
    具体代理类是在程序运行期间自动创建的，
    
## 动态代理- 具体代理类的自动创建Proxy.ProxyClassFactory与反射

 自动创建代理类方法调用顺序：
 
 ~~~
 Proxy#newProxyInstance() 
 -> Proxy#getProxyClass0() 
 -> return proxyClassCache.get(loader, interfaces);实际为：WeakCache<>(new KeyFactory(), new ProxyClassFactory()) 
 -> Proxy.ProxyClassFactory
 ~~~
### Proxy.ProxyClassFactory
返回一个由给定的ClassLoader与interfaces数组定义的代理类

主要实现步骤：

~~~
private static final class ProxyClassFactory implements BiFunction<ClassLoader, Class<?>[], Class<?>>{
    //……
    @Override
    apply(ClassLoader loader, Class<?>[] interfaces) {

        Map<Class<?>, Boolean> interfaceSet = new IdentityHashMap<>(interfaces.length);

        for (Class<?> intf : interfaces) {
            // 使用反射
            1. 验证类加载器是否将此接口的名称解析为同一Class对象。
            2. 验证Class对象实际上代表一个接口
            3. 验证此接口不是重复的。
        }
        
        // 记录非公共代理接口的包，以便将在同一包中定义代理类。验证所有非公共代理接口都在同一程序包中
        for (Class<?> intf : interfaces) {  
        }
        
        // 如果没有非公共代理接口，请使用com.sun.proxy包。
        proxyPkg = ReflectUtil.PROXY_PACKAGE + ".";
        
        // 选择要生成的代理类的名称。
        long num = nextUniqueNumber.getAndIncrement();
                    String proxyName = proxyPkg + proxyClassNamePrefix + num;
        
        // 生成指定的代理类。
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                        proxyName, interfaces, accessFlags);

        // 通过调用native方法，返回具体代理类的class文件
        return defineClass0(loader, proxyName,
                                    proxyClassFile, 0, proxyClassFile.length);
    }
}
~~~

综上所述，一个运行时具体代理类的产生是通过：

1. 
    
## 工厂模式

> 参考：https://www.cnblogs.com/panxuejun/p/7811213.html
> 参考：https://blog.csdn.net/jason0539/article/details/44976775
> 参考：https://www.jb51.net/article/85699.htm
 
 工厂模式主要是为创建对象提供了接口。
 
  - 简单工厂
  - 工厂方法
  - 抽象工厂
  
### 工厂方法
  
  1个产品抽象类 -> 多个具体产品类
  1个工厂抽象类 -> 多个具体工厂类
  1个具体工厂类 -> 创建1个具体产品
  
### 抽象工厂
    
    抽象工厂 --创建--> 多个抽象产品
    抽象工厂实现类 --创建--> 包含多个'抽象产品实现类'的具体产品
    类似树状：具体产品{具体抽象产品1、具体抽象产品2……}
  
  多个产品抽象类 -> 每一个抽象产品类产生多个具体产品类
  1个工厂抽象类  -> 多个具体工厂类
  1个具体工厂类  -> 创建多个具体产品类
  