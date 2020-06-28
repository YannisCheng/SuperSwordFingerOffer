package base.data_structure.tree.structure;

/**
 * BinaryAVLTree 平衡二叉搜索树
 * <p>
 * 出现的原因：
 * 二叉搜索树在特定条件下会出现"单右树"或"单左树"的情况，
 * 使其'插入时间复杂'度由'O（logn）'变为'O(n)'。
 * <p>
 * 解决的问题：
 * 1、保持二叉树的高度平衡；
 * 2、尽量降低二叉树的高度；
 * 3、减少二叉树的平均查找长度
 * <p>
 * 性质：
 * 1、左子树与右子树的高度差不超过1；
 * 2、树的每个左子树和右子树都是AVL树；
 * 3、每一个节点都有一个平衡因子（balance factor），任意节点的平衡因子是：-1，0，1
 * （每一个节点的平衡因子 = 右子树高度-左子树高度）
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/28 - 09:27
 */
public class BinaryAVLTree {
}
