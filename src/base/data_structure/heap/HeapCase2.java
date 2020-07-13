package base.data_structure.heap;

public class HeapCase2 {

    public static void main(String[] args) {
        int[] arr = {91,60,96,13,35,65,46,65,10,30,20,31,77,81,22};
        heapSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    /**
     * 创建堆，
     * @param arr 待排序列
     */
    private static void heapSort(int[] arr) {
        //创建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            System.out.println("i="+i);
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新对堆进行调整
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调整堆
     * @param arr 待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private static void adjustHeap(int[] arr, int parent, int length) {
        //将temp作为父节点
        int temp = arr[parent];
        System.out.printf("parent=%d, arr[parent]e=%d, ",parent,arr[parent]);
        //左孩子
        int lChild = 2 * parent + 1;
        System.out.println("lChild="+lChild);

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            System.out.printf("rChild=%d, arr[rChild]=%d",rChild,arr[rChild]);
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[lChild]) {
                System.out.println("结束");
                break;
            }

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[lChild];
            System.out.printf("change data is: arr[parent]=%d\n",arr[lChild]);

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
            System.out.printf("parent=%d,lChild=%d\n",parent,lChild);
        }
        arr[parent] = temp;
        System.out.println("end arr[parent]="+arr[parent]);

    }
}
