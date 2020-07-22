package base.design_patterns.proxy;

import base.design_patterns.proxy.dynamic_proxy.DynamicProxy;
import base.design_patterns.proxy.static_proxy.ProxyPeople;
import base.design_patterns.proxy.static_proxy.RealPeople;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * RunTest 测试类
 * <p>
 * 静态代理：在程序运行前就已经存在代理类的字节码文件，代理类和委托类的关系在运行前就确定了。
 * <p>
 * 动态代理：代理类的源码是在程序运行期间根据 反射等机制 动态的生成，所以不存在代理类的字节码文件。
 * 代理类和委托类的关系是在程序运行时确定。
 *
 * 参考：https://blog.csdn.net/yaomingyang/article/details/80981004
 * </p>
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/7/22 11:28
 */
public class RunTest {

    public static void main(String[] args) {
        /*
         * 静态代理示例：
         * 模拟"海外代购"的实现方式
         */
        //staticProxyCase();

        /*
         * 动态代理示例
         */
        dynamicProxyCase();
    }

    private static void dynamicProxyCase() {
        // 国内真实购买人
        RealPeople realPeople = new RealPeople();
        DynamicProxy dynamicProxy = new DynamicProxy(realPeople);
        /**
         * 大致实现原理：动态代理的实现通过比对"静态代理类"的实现即可。
         * #newProxyInstance()：返回一个被代理对象的实例，然后向上转型为其对应的接口。
         * 参数说明：
         * loader     ：被代理的类
         * interfaces ：代理类要实现的接口
         * h          ：已经实现"InvocationHandler"接口的类的对象，当代理对象调用方法时，会通过"此对象"的#invoke()来进行"被代理类的方法调用"
         */
        People proxyInstance = (People) Proxy.newProxyInstance(realPeople.getClass().getClassLoader(), new Class[]{People.class}, dynamicProxy);
        generateClassFile(DynamicProxy.class, "DynamicProxy");
        proxyInstance.buy();
        proxyInstance.eat();
        proxyInstance.wash();
    }


    private static void staticProxyCase() {
        // 国内真实购买人
        RealPeople realPeople = new RealPeople();
        // 代购人员
        ProxyPeople proxyPeople = new ProxyPeople(realPeople);
        // 代购人员 实现 国内真实购买人的"buy"需求
        proxyPeople.buy();
        proxyPeople.eat();
        proxyPeople.wash();
    }

    public static void generateClassFile(Class clazz, String proxyName) {
        //根据类信息和提供的代理类名称，生成字节码
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        String paths = "/Users/yannischeng/Projects_Map/Projects_IDEA_Java/SuperSwordFingerOffer/";
        System.out.println(paths);
        FileOutputStream out = null;

        try {
            //保留到硬盘中
            out = new FileOutputStream(paths + proxyName + ".class");
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
