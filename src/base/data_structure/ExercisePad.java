package base.data_structure;

import java.util.Arrays;

/**
 * ExercisePad 临时测试用例
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/7/10 17:04
 */
public class ExercisePad {

    public static void main(String[] args){
        ExercisePad exercisePad = new ExercisePad(10);
        int[] num = {2, 5, 1, 9, 0, 4, 6, 3};
        for (int i = 0; i < num.length; i++) {
            exercisePad.insert(num[i]);
        }
    }

    public int allNum;
    private int[] data;
    private int currentNum;

    public ExercisePad(int allNum) {
        this.allNum = allNum;
        data = new int[allNum+1];
        currentNum = 1;
    }

    public void insert(int item){
        if (currentNum >= allNum) {
            return;
        }

        data[currentNum] = item;
        int tempIndex = currentNum;
        while (tempIndex/2 >0 && data[tempIndex] > data[tempIndex/2]) {
            int temp = data[tempIndex];
            data[tempIndex] = data[tempIndex/2];
            data[tempIndex/2] = temp;
            tempIndex = tempIndex/2;
        }
        currentNum++;

        System.out.println(Arrays.toString(data));
    }
}
