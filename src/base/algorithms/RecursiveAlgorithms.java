package base.algorithms;

import java.math.BigInteger;

/**
 * RecursiveAlgorithm 递归算法类
 * <p>
 * 递归思想就是将一个问题转换为一个已解决的问题来实现，
 * 解决问题的关键："忽略小细节,注重大步骤。" —— 递归的精华所在.
 * <p>
 * 递归三要素：
 * 1、递归函数是干什么的？
 * 2、递归的结束条件？
 * 3、递归函数的等价关系式（缩小参数范围）
 * <p>
 * 参考：
 * https://blog.csdn.net/dreamispossible/article/details/90552557
 * https://blog.csdn.net/qq_41359051/article/details/85276387
 * https://www.cnblogs.com/gshao/p/9535687.html
 * <p>
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/28 - 10:47
 */
public class RecursiveAlgorithms {
    private static int moveCount;

    public static void main(String[] args) {
        // 汉诺塔
        // aboutHanota();

        // 阶乘：n!
        // aboutFactorial();

        // 阶乘累加：1!+2!+3!+……+n!
        // aboutFactorialAdd();

        // 棋盘放麦子
        // aboutCheckerboard();

        // 斐波那契数列
        // aboutFibonacciSequence();

        // 倒序输出一个正整数
        aboutReverseOutputInteger();

        // 青蛙跳台阶问题
        //frogJumpingSteps();
    }

    /**
     * 青蛙跳台阶问题
     * 问题描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */
    private static void frogJumpingSteps() {
        System.out.println("青蛙跳台阶跳法有"+frogJump(4)+"种");;
    }

    private static int frogJump(int n) {
        if (n <=2) {
            return 1;
        }
        return frogJump(n-1)+frogJump(n-2);
    }

    /**
     * 倒序输出一个正整数
     */
    private static void aboutReverseOutputInteger() {
        reverseOutPut(1374359378);
    }

    private static void reverseOutPut(int number) {
        System.out.println(number%10);
        //System.out.println(number/10);
        if (number>10) {
            reverseOutPut(number/10);
        }
    }

    /**
     * 阶乘
     * 只关注大步骤，忽略小细节，实现'阶乘'如此轻松。
     */
    private static void aboutFactorial() {
        int num = factorial(4);
        System.out.println("阶乘= " + num);
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * 阶乘累加
     */
    private static void aboutFactorialAdd() {
        int num = factorialAdd(4);
        System.out.println("阶乘累加的结果为：" + num);
    }

    private static int factorialAdd(int n) {
        if (n == 1) {
            return 1;
        }
        return factorial(n) + factorial(n - 1);
    }

    /**
     * 棋盘放麦粒
     * 18446744073709551615
     * <p>
     * 一位国王打算奖赏他的臣子。臣子说：那就奖赏我一些麦粒吧：
     * 国际象棋盘上的第1个格子放1粒麦粒，第2个格子放2粒，第3个格子4粒，以此类推8、16…即：
     * 1->1;
     * 2->2;
     * 3->4;
     * 4->8;
     * 5->16
     * 直到放满64个格子(2的指数)。
     */
    private static void aboutCheckerboard() {
        // for循环实现
        //System.out.println("麦粒 num is : " + checkBoardByFor());
        // 递归实现
        System.out.println("麦粒 num is : " + checkBoardByRecursive(5));
    }

    private static int checkBoardByRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return (int) Math.pow(2, (n - 1)) + checkBoardByRecursive(n - 1);
    }

    private static String checkBoardByFor() {
        BigInteger a = new BigInteger("0");
        // new BigInteger("2") 中的'2'为指数的'底数'
        // pow()方法的参数为：'以2为底的指数'中的'指数'
        BigInteger b = new BigInteger("2");

        for (int i = 0; i < 64; i++) {
            a = a.add(b.pow(i));
        }
        System.out.println(a);
        return a.toString();
    }

    /**
     * 斐波那契数列（又称：黄金分割数列）：
     * 因数学家列昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，故又称为“兔子数列”。
     * 在数学上，斐波纳契数列以如下被以递归的方法定义：F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）。
     * 是这样一个数列：1、1、2、3、5、8、13、21、34、55、89…
     * 其实真正的数列样式为：0、1、1、2、3、5、8、13、21、34、55、89、144…
     */
    private static void aboutFibonacciSequence() {
        // 设置一个较大的值：400。
        // 当值为400时，递归到40个左右时已经非常慢了。
        testDoFib();

        //doFibonacciSequenceByFor(400);
    }

    private static void testDoFib() {
        long timeMillis = System.currentTimeMillis();
        // i从1开始
        // 第46个数的斐波那契数列值 = 1134903170
        for (int i = 0; i < 14; i++) {
            int num = doFsByRecursive(i);
            System.out.println("第" + i + "个数的斐波那契数列值 = " + num);
        }
        showUseTime(timeMillis);
    }

    private static int doFsByFor(int n) {
        long timeMillis = System.currentTimeMillis();
        int res[] = {0, 1};
        if (n < 2) {
            return res[n];
        }

        int first = 0;
        // 此时的second为第3个位置的值，第3个位置的值=1；
        int second = 1;
        int putValue = 0;

        for (int i = 2; i < n; i++) {
            putValue = first + second;
            System.out.println("第" + i + "个位置的 putValue is = " + putValue);
            first = second;
            System.out.println("第" + i + "个位置的 first is = " + first);
            second = putValue;
            System.out.println("第" + i + "个位置的 second is = " + second);
        }
        showUseTime(timeMillis);

        return putValue;
    }

    private static void showUseTime(long timeMillis) {
        System.out.println("耗时：" + (System.currentTimeMillis() - timeMillis) + "毫秒");
    }

    private static int doFsByRecursive(int n) {
        // 特殊条件
        if (n == 0) {
            return 0;
        }

        // 特殊条件
        if (n == 1) {
            return 1;
        }

        // 正常操作
        return doFsByRecursive(n - 1) + doFsByRecursive(n - 2);
    }

    /**
     * 汉诺塔（又称河内塔）
     * <p>
     * 问题是源于印度一个古老传说的益智玩具。
     * 大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。
     * 大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。
     * 并且规定：一次只移动一片，不管在哪根针上，小片必须在大片上面。
     */
    private static void aboutHanota() {
        // 计数器
        moveCount = 0;
        hannota(3, 'A', 'B', 'C');
        System.out.println("移动次数为：" + moveCount);
    }

    /**
     * 汉诺塔实现
     * 把大象装进冰箱需要几步？
     * 1：打开冰箱门；
     * 2：把大象装进去（怎么装？不知道）；
     * 3：关上冰箱门。
     * <p>
     * 重要的就是注意参数。
     * 考虑内部的时候,不要一直把A就当作 from,B当作 buffer,C当作 to；
     * 而是根据hannota(n,参数1,参数2,参数3),因为A,C也可以充当辅助柱子；
     * 这里固定不变的是:参数1,为原柱子,2为辅助柱,3为目标柱
     *
     * @param n      最初A杆上的盘子个数
     * @param from   起始杆
     * @param buffer 缓冲杆
     * @param to     目的杆
     */
    private static void hannota(int n, char from, char buffer, char to) {
        moveCount++;
        // 将最后剩下的编号为n的盘子从A挪到C
        if (n == 1) {
            System.out.println("from # " + from + " move " + n + " to " + to);
            return;
        }
        // 将编号为1~(n-1)的盘子从A全部挪到缓冲区B
        hannota(n - 1, from, to, buffer);
        System.out.println("from - " + from + " move " + n + " to " + to);
        // 将B杆上留下的(n-1)个盘子从缓冲区B挪到C
        hannota(n - 1, buffer, from, to);
    }
}
