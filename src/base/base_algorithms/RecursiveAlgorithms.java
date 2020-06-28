package base.base_algorithms;

/**
 * RecursiveAlgorithm 递归算法类
 *
 * 递归思想就是将一个问题转换为一个已解决的问题来实现
 * <p>
 * 参考：
 * https://blog.csdn.net/dreamispossible/article/details/90552557
 * https://blog.csdn.net/qq_41359051/article/details/85276387
 * https://www.cnblogs.com/gshao/p/9535687.html
 * <p>
 * 递归三要素：
 * 1、递归函数是干什么的？
 * 2、递归的结束条件？
 * 3、递归函数的等价关系式（缩小参数范围）
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/28 - 10:47
 */
public class RecursiveAlgorithms {

    public static void main(String[] args) {

        // 汉诺塔
        aboutHanota();

        // 棋盘放麦子
        aboutFibonacciSequence();

        // 斐波那契数列
        aboutCheckerboard();

        // 阶乘
        aboutFactorial();

        // 倒序输出一个正整数
        aboutReverseOutputInteger();
    }

    /**
     * 倒序输出一个正整数
     */
    private static void aboutReverseOutputInteger() {

    }

    /**
     * 阶乘
     */
    private static void aboutFactorial() {

    }

    /**
     * 棋盘放麦粒
     * <p>
     * 一位国王打算奖赏他的臣子。臣子说：那就奖赏我一些麦粒吧：
     * 国际象棋盘上的第一个格子放1粒麦粒，第二个格子放2粒，第三个格子4粒，以此类推8、16…直到放满64个格子。
     */
    private static void aboutCheckerboard() {

    }

    /**
     * 斐波那契数列
     * <p>
     * 是这样一个数列：1、1、2、3、5、8、13、21、34…，
     */
    private static void aboutFibonacciSequence() {
        

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

    }
}