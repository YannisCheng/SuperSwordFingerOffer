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
 * "二叉查找树"通过使用"二叉链表存储"实现，中广泛的使用了"递归思想"
 * <p>
 * 基本操作：
 * 增、删、改、查
 * <p>
 * 遍历方法4种
 * <p>
 * 二叉树的存储结构分为：
 * 1：二叉链表。每个节点仅存储父节点到子节点的单向关系
 * 特点：遍历耗时，遍历时间完全取决于待查节点位置。
 * 2：三叉链表。每个结点存储了父节点与子节点之间的双向关系
 * 特点：空间资源占用大，遍历时间快
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
        return size(root);
    }

    private int size(BinaryTreeNode<T> node) {
        int num = 0;
        if (node == null) {
            return 0;
        } else {
            // 1 为 root节点本身
            // System.out.println("left: "+node.getLeft());
            // System.out.println("right: "+node.getRight());
            return size(node.getLeft()) + 1 + size(node.getRight());
        }
    }

    @Override
    public int height() {
        return height(root);
    }

    /**
     * 高度
     *
     * @param node 待查节点
     * @return 高度
     */
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
        root = insert(data, root);
    }

    /**
     * 插入元素
     * 此方法采用的"递归"的原子操作：
     * 每一个节点的插入都有：节点、节点左子树、节点右子树；
     * 每次插入时都要确定：插入的位置、插入的数值、插入的数值所依赖的节点
     *
     * @param data 待插入节点所持有的数值
     * @param node 待插入节点（根节点、右子树节点<空>、左子树节点<空>）
     * @return 已插入的所有节点
     */
    private BinaryTreeNode<T> insert(T data, BinaryTreeNode<T> node) {

        /*在已经插入：4，6，8数值节点的情况下插入数值9，运行结果：
         * start node.data = 4
         * right: node.data = 4
         * start node.data = 6
         * right: node.data = 6
         * start node.data = 8
         * right: node.data = 8
         * init node == null,data = 9
         * start node.data = 9
         * 相等:已有元素无需输入
         * end node : 9
         * end node : 8
         * end node : 6
         * end node : 4
         */
        if (node == null) {
            // 每次插入新节点都会执行这一句代码：
            // 待插入节点（根节点、右子树节点<空>、左子树节点<空>）
            //System.out.println("init node == null,data = " + data);
            node = new BinaryTreeNode<T>(data, null, null);
        }
        //System.out.println("start node.data = " + node.getData());

        // 比较结果说明：
        // 如果当前node的'compareTag < 0'，那表示：当前左子树节点还有叶子左子树，还可以继续遍历；
        // 如果当前node的'compareTag > 0'，那表示：当前右子树节点还有叶子右子树，还可以继续遍历；
        //    终止流程：'node = new BinaryTreeNode<T>(data, null, null)' -> 'compareTag == 0'；-> return node;
        // 如果当前node的'compareTag == 0'，那表示：当前node节点就是新添加的叶子节点
        //
        // 简单步骤说明：
        // 1：如果是插入新节点前(如待插入data=6，root node.data = 4;)那么则会执行：
        // 'compareTag > 0' -> node.setRight(insert(data, node.getRight()));
        // 2：如果第1步已经执行'node.setRight(insert(data, node.getRight()))'，那么则会执行：
        // 'compareTag == 0' -> return node;
        int compareTag = data.compareTo(node.getData());
        if (compareTag < 0) {
            // 左
            //System.out.println("left: node.data = " + node.getData());
            // 每次插入时都要确定：插入的位置、插入的数值、插入的数值所依赖的节点
            node.setLeft(insert(data, node.getLeft()));
        } else if (compareTag > 0) {
            // 右
            //System.out.println("right: node.data = " + node.getData());
            node.setRight(insert(data, node.getRight()));
        } else {
            // = = 退出条件,中断自我方法调用 = =
            // 相等:已有元素无需输入
            //System.out.println("相等:已有元素无需输入");
        }
        //System.out.println("end node : " + node.getData());
        // return顺序：由内而外
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
        String s = "";
        s = prevTraverse(root);
        return s;
    }

    /**
     * 先序遍历
     *
     * @param node 待遍历的节点
     * @return 遍历结果
     */
    private String prevTraverse(BinaryTreeNode<T> node) {
        StringBuilder str = new StringBuilder();
        // 3个节点的"原子操作"
        /*if (node != null) {
            str.append(node.getData());
            str.append(node.getLeft().getData());
            str.append(node.getRight().getData());
        }*/

        if (node != null) {
            str.append(node.getData());
            str.append(prevTraverse(node.getLeft()));
            str.append(prevTraverse(node.getRight()));
        }/* else {
            throw new RuntimeException("二叉搜索树不能为空");
        }*/
        return str.toString();
    }

    @Override
    public String midTraverse() {
        String str = "";
        str = midTraverse(root);
        return str;
    }

    /**
     * 中序遍历
     *
     * @param node 待遍历的节点
     * @return 遍历结果
     */
    private String midTraverse(BinaryTreeNode<T> node) {
        StringBuilder str = new StringBuilder();
        if (node != null) {
            str.append(midTraverse(node.getLeft()));
            str.append(node.getData());
            str.append(midTraverse(node.getRight()));
        }
        return str.toString();
    }

    @Override
    public String rearTraverse() {
        String str = "";
        str = rearTraverse(root);
        return str;
    }

    /**
     * 后序遍历
     *
     * @param node 待遍历的节点
     * @return 遍历结果
     */
    private String rearTraverse(BinaryTreeNode<T> node) {
        StringBuilder str = new StringBuilder();
        if (node != null) {
            str.append(rearTraverse(node.getLeft()));
            str.append(rearTraverse(node.getRight()));
            str.append(node.getData());
        }
        return str.toString();
    }

    @Override
    public String levelTraverse() {
        String str = "";

        return str;
    }


    @Override
    public BinaryTreeNode<T> findMax() {
        return findMax(root);
    }

    /**
     * 查找树中的最大值
     *
     * @param node 待查节点
     * @return 节点
     */
    private BinaryTreeNode<T> findMax(BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.getRight() == null) {
            return node;
        }

        return findMax(node.getRight());
    }

    @Override
    public BinaryTreeNode<T> findMin() {
        return findMin(root);
    }

    /**
     * 查找树中的最小值
     *
     * @param node 待查节点
     * @return 节点
     */
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
