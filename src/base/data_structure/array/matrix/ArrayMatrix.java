package base.data_structure.array.matrix;

public class ArrayMatrix {

    public static void main(String[] args) {
        generateArrayMatrix();
    }

    /**
     * 利用随机函数生成一个4×4的矩阵(即二维矩阵),范围是[20,50]内的整数，
     * 求它的两条对角线上元素之和。
     */
    private static void generateArrayMatrix() {
        int sum = 0;
        int[][] numArr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                numArr[i][j] =  (int) (Math.random()*(50-20)+20);
                System.out.print(numArr[i][j]+"  ");
                if (i == j) {
                    sum += numArr[i][j];
                }
            }
            System.out.println();
        }
        System.out.println("两条对角线上元素之和: sum="+sum);
    }
}
