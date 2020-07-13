package base.data_structure.heap;

import java.util.Arrays;

/**
 * heap structure
 */
public class HeapCase4 {

    public static void main(String[] args) {
        int[] array = {2, 5, 1, 9, 0, 4, 6, 3};
        HeapCase4 heapCase4 = new HeapCase4(array.length);
        for (int i = 0; i < array.length; i++) {
            heapCase4.insert(array[i]);
        }

        System.out.println("num is: "+heapCase4.getSize());

        for (int i = 0; i < array.length; i++) {
            System.out.println(heapCase4.removeMax());
        }
    }

    int currentNum;
    int allNum;
    int[] data;

    public HeapCase4(int allNum) {
        this.allNum = allNum;
        data = new int[allNum+1];
        currentNum = 0;
    }

    public int getSize(){
        return currentNum;
    }

    public void insert(int item){
        if (currentNum>allNum) {
            return;
        }

        data[currentNum+1] = item;
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


    public int removeMax(){
        if (currentNum<1) {
            return 0;
        }
        int temp = data[1];
        data[1] = data[currentNum];
        // has remove one;
        currentNum--;
        // sort other enum
        shiftDown(1);
        return temp;
    }

    private void shiftDown(int i) {
        while (i*2 <= currentNum) {
            int leftChild = i*2;
            if (leftChild <=currentNum && data[leftChild+1] > data[leftChild]) {
                leftChild++;
            }
            if (data[i] > data[leftChild]) {
                break;
            }
            int temp = data[i];
            data[i] = data[leftChild];
            data[leftChild] = temp;
            i=leftChild;
        }
    }


}
