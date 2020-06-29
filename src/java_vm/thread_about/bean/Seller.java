package java_vm.thread_about.bean;

/**
 * Seller 售票员
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/29 - 08:26
 */
public class Seller implements Runnable {

    private Ticker ticker;

    public Seller(Ticker mTicker) {
        this.ticker = mTicker;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Seller.class) {
                if (ticker.getCount() <= 0) {
                    break;
                }

                try {
                    Thread.sleep(100);
                    ticker.setCount(ticker.getCount() - 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 获取线程的名字
                String name = Thread.currentThread().getName();
                System.out.println(name + "卖了1张票，剩余: " + ticker.getCount());
            }
        }
    }
}
