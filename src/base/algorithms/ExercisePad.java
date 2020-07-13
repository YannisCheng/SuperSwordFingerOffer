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
    private static final int[] TEMP = new int[ARR.length];

    public static void main(String[] args) {
        ExercisePad pad = new ExercisePad(ARR.length);
        for (int i = 0; i < ARR.length; i++) {
            pad.insert(ARR[i]);
        }
        System.out.println(Arrays.toString(pad.data));
        pad.remove();
        System.out.println(Arrays.toString(pad.data));
    }

    private int allNum;
    private int currenNum;
    private int[] data;

    public ExercisePad(int allNum) {
        this.allNum = allNum;
        data = new int[allNum+1];
        currenNum = 1;
    }

    public  void insert(int item){
        if (currenNum > allNum) {
            return;
        }
        data[currenNum] = item;
        int currentItem = currenNum;
        while (currentItem/2 >0 && data[currentItem] >data[currentItem/2]) {
            int temp = data[currentItem];
            data[currentItem] = data[currentItem/2];
            data[currentItem/2] = temp;
            currentItem = currentItem/2;
        }
        currenNum++;
    }

    public void remove(){
        if (currenNum == 1) {
            return;
        }

        currenNum--;
        data[1] = data[currenNum];
        data[currenNum] = 0;
        heapIfy(data,currenNum,1);

    }

    private void heapIfy(int[] data, int n, int i) {
        int maxIndex = i;
        while (true) {
            if (2*i < n && data[2*i] > data[i]) {
                maxIndex = 2*i;
            }

            if (2*i+1 < n && data[2*i+1] >data[maxIndex]) {
                maxIndex = 2*i+1;
            }

            if (maxIndex == i) {
                break;
            }

            int temp = data[i];
            data[i] = data[maxIndex];
            data[maxIndex] = temp;

            i = maxIndex;
        }

    }

    public static void showSingleSort(int i) {
        System.out.println("第" + (i + 1) + "次的结果为：" + Arrays.toString(ARR));
    }

    public static void showSort() {
        System.out.println(Arrays.toString(ARR));
    }
}
