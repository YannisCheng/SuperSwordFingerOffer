package base.design_patterns.proxy.static_proxy;

import base.design_patterns.proxy.People;

/**
 * ProxyPeople 代理购买购买人（国外代购）
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/7/22 11:26
 */
public class ProxyPeople implements People {

    private final People people;

    public ProxyPeople(People people) {
        this.people = people;
    }

    @Override
    public void buy() {
        System.out.println("海外代购满足你：");
        people.buy();
    }

    @Override
    public void eat() {
        System.out.println("外卖满足你：");
        people.eat();
    }

    @Override
    public void wash() {
        System.out.println("洗衣店满足你：");
        people.wash();
    }
}
