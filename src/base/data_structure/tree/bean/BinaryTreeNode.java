package base.data_structure.tree.bean;

import java.io.Serializable;

/**
 * BinaryTree 二叉树：二叉节点
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/21 - 21:14
 */
public class BinaryTreeNode<T extends Comparable> implements Serializable {
    private T data;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    /**
     * 是否为叶子节点
     *
     * @return true：是
     */
    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "data=" + data +
                '}';
    }
}
