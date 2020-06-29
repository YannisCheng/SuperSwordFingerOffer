package java_vm.thread_about;

/**
 * SaveMoneyOrder 按执行线程顺序执行,'join'使用
 * #saveMoney()方法没有进行 '同步'操作
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/29 - 11:32
 */
public class ThreadJoin {

    private int value = 100;

    public void save() throws InterruptedException {
        Save1 save1 = new Save1();
        Save2 save2 = new Save2();
        Save3 save3 = new Save3();


        // 按顺序执行: save1 -> save2 -> save3 -> main
        save1.start();
        save1.join();
        save2.start();
        save2.join();
        save3.start();
        save3.join();
        showState(save1);
        showState(save2);
        showState(save3);
        try {
            Thread.sleep(100);
            System.out.println("最后账户=" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private void showState(Thread thread){
        System.out.println(thread.getName()+",state: "+ thread.getState());
    }

    class Save1 extends Thread {
        @Override
        public void run() {
            super.run();

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            saveMoney(1, 10, Thread.currentThread().getName());
        }
    }

    class Save2 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            saveMoney(2, 40, Thread.currentThread().getName());
        }
    }

    class Save3 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            saveMoney(3, 30, Thread.currentThread().getName());
        }
    }

    private void saveMoney(int time, int money, String tName) {
        try {
            Thread.sleep(100);
            value += money;
            System.out.println("线程：" + tName + "，第【" + time + "】次存钱，账户=" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
