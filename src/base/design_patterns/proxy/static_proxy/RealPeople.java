package base.design_patterns.proxy.static_proxy;

import base.design_patterns.proxy.People;

/**
 * RealPeople 真实购买人（国内）
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/7/22 11:25
 */
public class RealPeople implements People {
    @Override
    public void buy() {
        System.out.println("    我要购买一个包");
    }

    @Override
    public void eat() {
        System.out.println("    我要吃东西");
    }

    @Override
    public void wash() {
        System.out.println("    我要洗衣服");
    }
}
