package base.data_structure.tree.structure;

import base.data_structure.tree.bean.BinaryTreeNode;
import base.data_structure.tree.inteface.BinaryTree;

/**
 * BinarySearchTree 通过'二叉节点'实现二叉查找树
 * <p>
 * 二叉树分为：满二叉树、完全二叉树
 * <p>
 * 二叉查找树特性：
 * 1：对于树中的每个节点T（可能是父节点），他的左子树中所有项的值小于T节点中的值；
 * 2：对于树中每个节点T（可能是父节点），他的右子树中的所有项的值大于T节点中的值。
 * 这表示该树中的所有节点均按照某一种规则（对Comparable的实现）进行排序；
 * <p>
 * "二叉查找树"通过使用"二叉链表存储"实现。
 * <p>
 * "二叉查找树"中广泛的使用了"递归思想"
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/24 - 15:22
 */
public class BinarySearchTree<T extends Comparable> implements BinaryTree<T> {

    /**
     * 根节点
     */
    private BinaryTreeNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int height(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        } else {
            int left = height(node.getLeft());
            int right = height(node.getRight());
            return (left > right) ? (left + 1) : (right + 1);
        }
    }

    @Override
    public void insert(T data) {
        if (data == null) {
            throw new RuntimeException("data 不能为空");
        }
        insert(data, root);
    }

    private BinaryTreeNode<T> insert(T data, BinaryTreeNode<T> node) {
        if (node == null) {
            node = new BinaryTreeNode<T>(data, null, null);
        }

        int compareTag = data.compareTo(node.getData());

        if (compareTag < 0) {
            // 左
            node.setLeft(insert(data, node.getLeft()));
        } else if (compareTag > 0) {
            // 右
            node.setRight(insert(data, node.getRight()));
        } else {
            // 相等:已有元素无需输入
        }

        return node;
    }

    @Override
    public boolean remove(T data) {
        root = remove(data, root);
        return false;
    }

    private BinaryTreeNode<T> remove(T data, BinaryTreeNode<T> node) {

        if (data == null) {
            throw new RuntimeException("data 不能为空");
        }

        int compareTag = data.compareTo(node.getData());

        if (compareTag < 0) {
            node.setLeft(remove(data, node.getLeft()));
        } else if (compareTag > 0) {
            node.setRight(remove(data, node.getRight()));
        } else {
            //
            if (node.getLeft() != null && node.getRight() != null) {
                node.setData(findMin(node.getRight()).getData());
                node.setRight(remove(node.getData(), node.getRight()));
            } else {
                //拥有一个孩子结点的结点和叶子结点的情况
                node = (node.getRight() == null) ? node.getLeft() : node.getRight();
            }
        }

        return node;
    }


    @Override
    public String prevTraverse() {
        return null;
    }

    @Override
    public String midTraverse() {
        return null;
    }

    @Override
    public String rearTraverse() {
        return null;
    }

    @Override
    public String levelTraverse() {
        return null;
    }

    @Override
    public BinaryTreeNode<T> findMax(BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.getRight() == null) {
            return node;
        }

        return findMax(node.getRight());
    }

    @Override
    public BinaryTreeNode<T> findMin(BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.getLeft() == null) {
            return node;
        }
        return findMin(node.getLeft());
    }

    @Override
    public BinaryTreeNode findNode(T data) {
        return null;
    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public void clear() {

    }
}
