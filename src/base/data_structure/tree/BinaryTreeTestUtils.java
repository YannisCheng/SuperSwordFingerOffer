package base.data_structure.tree;

import base.data_structure.tree.structure.BinarySearchTree;

/**
 * 树测试工具类
 * 2020-6-21 21:15:15
 */
public class BinaryTreeTestUtils {

    public static void main(String[] args) {
        int[] array = {4,6,1,8,9,5,7,2};
        BinarySearchTree<Integer> searchTree = new BinarySearchTree<Integer>();
        /*for (int i = 0; i < array.length; i++) {
            searchTree.insert(array[i]);
        }*/

        searchTree.insert(4);
        searchTree.insert(6);
        searchTree.insert(8);
        searchTree.insert(9);

        searchTree.prevTraverse();
        System.out.println("size : "+searchTree.size());
    }
}
