package base.algorithms;

import java.util.Arrays;

/**
 * ExercisePad 算法练手板
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/28 - 16:55
 */
public class ExercisePad {
    private static final int[] ARR = {3, 5, 1, 9, 6, 8, 4, 7, 2};

    public static void main(String[] args) {


    }

    /**
     *      A       B       C
     * 1层：A->C
     * 2层：
     * 3层：
     *
     */
    public static void showSingleSort(int i) {
        System.out.println("第" + (i + 1) + "次的结果为：" + Arrays.toString(ARR));
    }

    public static void showSort() {
        System.out.println(Arrays.toString(ARR));
    }
}
