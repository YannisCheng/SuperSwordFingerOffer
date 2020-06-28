package base.data_structure.tree.inteface;

import base.data_structure.tree.bean.BinaryTreeNode;

/**
 * BinaryTree 二叉树抽象数据类型的顶级接口
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/24 - 14:21
 */
public interface BinaryTree<T extends Comparable> {

    /**
     * 是否为空
     *
     * @return true：空
     */
    boolean isEmpty();

    /**
     * 二叉树结点数量
     *
     * @return 数量
     */
    int size();

    /**
     * 二叉树的高度/深度（或结点的最大层次）
     *
     * @return 高度/深度
     */
    int height(BinaryTreeNode<T> node);

    /**
     * 插入节点
     *
     * @param data 待插入节点数据
     * @return true：插入成功
     */
    void insert(T data);

    /**
     * 移除节点
     *
     * @param data 移除给定数据的节点
     * @return true：移除成功
     */
    boolean remove(T data);

    /**
     * 先序遍历
     *
     * @return 先序遍历结果
     */
    String prevTraverse();

    /**
     * 中序遍历
     *
     * @return 中序遍历结果
     */
    String midTraverse();

    /**
     * 后序遍历
     *
     * @return 后序遍历结果
     */
    String rearTraverse();

    /**
     * 层级遍历
     *
     * @return 层级遍历结果
     */
    String levelTraverse();

    /**
     * 查找最大值
     *
     * @return 最大值
     */
    BinaryTreeNode<T> findMax(BinaryTreeNode<T> node);

    /**
     * 查找最小值
     *
     * @return 最小值
     */
    BinaryTreeNode<T> findMin(BinaryTreeNode<T> node);

    /**
     * 根据数值查找对应节点
     *
     * @param data 给定的查找数据
     * @return 给定数值对应的节点
     */
    BinaryTreeNode findNode(T data);

    /**
     * 是否包给定data的节点
     *
     * @param data 数据
     * @return true：包含
     */
    boolean contains(T data);

    /**
     * 清空
     */
    void clear();

}
