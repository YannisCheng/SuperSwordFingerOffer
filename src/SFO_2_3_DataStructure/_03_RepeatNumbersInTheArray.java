package SFO_2_3_DataStructure;

/**
 * 题目：03 - 数组中重复的数字
 * <p>
 * 描述：
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2
 * <p>
 * 考察点：
 * 1、1维数组在内存中占据连续的内存空间：根据下标定位到对应元素
 * 2、分析问题的能力：复杂问题通过具体例子找到规律
 * 。
 */
public class _03_RepeatNumbersInTheArray {
    public static final int[] arrNum = new int[]{2, 3, 5, 4, 3, 6, 2, 7};

    public static void main(String[] args) {


        // SortMaoPao(arrNum);
        // sortChoose(arrNum);

        // 排序：二分法

        // 排序：希尔

        // 排序：快排

        // 排序：堆

        // 排序：归并

        /*
         * 找出第1个重复的数字
         */
        for (int i = 0; i < arrNum.length - 1; i++) {
            if (arrNum[i] == arrNum[i + 1]) {
                System.out.println("anim:" + arrNum[i]);
                break;
            }
        }

        /*
         * 找出所有的重复数字
         */
        for (int i = 0; i < arrNum.length - 1; i++) {
            if (arrNum[i] == arrNum[i + 1]) {
                System.out.print("anim:" + arrNum[i]);
            }
        }
    }
}
