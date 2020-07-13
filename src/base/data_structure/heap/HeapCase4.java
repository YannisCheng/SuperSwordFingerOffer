package base.data_structure.heap;

import java.util.Arrays;

/**
 * heap structure
 */
public class HeapCase4 {

    public static void main(String[] args) {
        int[] array = {2, 5, 1, 9, 0, 4, 6, 3};
        HeapCase4 heapCase4 = new HeapCase4(10);
        for (int i = 0; i < array.length; i++) {
            heapCase4.insert(array[i]);
        }

    }

    int currentNum;
    int allNum;
    int[] data;

    public HeapCase4(int allNum) {
        this.allNum = allNum;
        data = new int[allNum+1];
        currentNum = 1;
    }

    public void insert(int item){
        if (currentNum>allNum) {
            return;
        }

        data[currentNum] = item;
        int index = currentNum;
        while (index>1 && data[index] > data[index/2]) {
            int temp = data[index];
            data[index] = data[index/2];
            data[index/2] = temp;
            index = index/2;
        }
        currentNum++;
        System.out.println(Arrays.toString(data));
    }



}
