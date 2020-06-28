package base.data_structure.tree;

import base.data_structure.tree.structure.BinarySearchTree;

/**
 * 树测试工具类
 * 2020-6-21 21:15:15
 */
public class BinaryTreeTestUtils {

    public static void main(String[] args) {
        BSTreeTest();
    }

    /**
     * 二叉搜索树-测试
     */
    private static void BSTreeTest() {
        int[] array = {4, 6, 1, 8, 9, 5, 7, 2};
        BinarySearchTree<Integer> searchTree = new BinarySearchTree<Integer>();
        for (int i = 0; i < array.length; i++) {
            searchTree.insert(array[i]);
        }

        System.out.println("节点数为：" + searchTree.size());
        System.out.println("height数为：" + searchTree.height());
        System.out.println("先序遍历：" + searchTree.prevTraverse());
        System.out.println("中序遍历：" + searchTree.midTraverse());
        System.out.println("后序遍历：" + searchTree.rearTraverse());

        System.out.println("当前二叉查找树的最大值为：" + searchTree.findMax().getData());
        System.out.println("当前二叉查找树的最小值为：" + searchTree.findMin().getData());
    }
}
