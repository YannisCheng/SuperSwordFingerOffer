package base.algorithms;

import java.util.Arrays;

/**
 * PrimeNumber 素数问题集合
 * <b>
 * 素数的性质只有1个：只有1和它本身这两个因数
 * 数学定理：只有形如 6n - 1 和 6n + 1 的自然数可能是素数（n>=1）。
 * <b>
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/7/10 10:53
 */
public class PrimeNumber {


    public static void main(String[] args) {
        // 素数判断
        // judgmentPrimeNumber(5);
        // 查找素数
        findPrimeNumber(100);
    }

    private static void judgmentPrimeNumber(int num) {
        int count = 0;
        if (num <= 2) {
            System.out.printf("%d is prime\n", num);
        } else {
            for (int i = 2; i < num; i++) {
                count++;
                if (num % i == 0) {
                    System.out.printf("%d is not prime。", num);
                    break;
                } else {
                    System.out.printf("%d is prime。", num);
                }
            }
            System.out.println();
            System.out.println("运行次数为："+count);
        }
    }

    /**
     * 埃拉托斯特尼筛法（简称埃氏筛或爱氏筛）
     * 比如我们要筛选出 100 以内的所有素数：
     * 我们知道 2 是最小的素数，我们先用 2 可以筛掉所有的偶数；
     * 然后往后遍历到 3 ，3 是被 2 筛剩下的第一个数，也是素数，我们再用 3 去筛除所有能被 3 整除的数。
     * 筛完之后我们继续往后遍历，第一个遇到的数是 7 ，所以 7 也是素数，我们再重复以上的过程，直到遍历结束为止。
     * 结束的时候，我们就获得了100以内的所有素数。
     *
     * @param num 数据
     */
    private static void findPrimeNumber(int num) {
        boolean[] check = new boolean[108];
        int[] primes = new int[num];
        int count = 0;

        for (int i = 2; i <= num; i++) {
            if (!check[i]) {
                primes[count++] = i;
            }
            for (int j = i+i; j <= num; j+=i) {
                System.out.println(j);
                check[j] = true;
            }
        }

        System.out.println(Arrays.toString(primes));
    }
}
