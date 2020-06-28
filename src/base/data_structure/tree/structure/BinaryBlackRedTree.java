package base.data_structure.tree.structure;

import base.data_structure.tree.bean.BinaryTreeNode;
import base.data_structure.tree.inteface.BinaryTree;

/**
 * BinaryBlackRedTree 红黑树
 * <p>
 * 参考：https://baijiahao.baidu.com/s?id=1641940303518144126&wfr=spider&for=pc
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/28 - 08:20
 */
public class BinaryBlackRedTree<T extends Comparable> implements BinaryTree<T> {
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public void insert(T data) {

    }

    @Override
    public boolean remove(T data) {
        return false;
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
    public BinaryTreeNode<T> findMax() {
        return null;
    }

    @Override
    public BinaryTreeNode<T> findMin() {
        return null;
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
