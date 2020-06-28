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

        maopao();
    }

    private static void maopao() {
        int sortNum = 0;
        for (int i = 0; i < ARR.length - 1; i++) {
            for (int j = 0; j < ARR.length - 1 - i; j++) {
                int temp = 0;
                sortNum++;
                if (ARR[j] > ARR[j + 1]) {
                    temp = ARR[j];
                    ARR[j] = ARR[j + 1];
                    ARR[j + 1] = temp;
                }
            }
            showSingleSort(i);
        }
        System.out.println("排序次数为：" + sortNum);
        showSort();
    }

    public static void showSingleSort(int i) {
        System.out.println("第" + (i + 1) + "次的排序结果为：" + Arrays.toString(ARR));
    }

    public static void showSort() {
        System.out.println(Arrays.toString(ARR));
    }
}
