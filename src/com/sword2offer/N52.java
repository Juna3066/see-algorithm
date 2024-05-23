package com.sword2offer;

import com.common.structure.TreeNode;
import com.common.utils.TreeNodeUtil;

import java.util.List;

/**
 * @author JUN
 */
public class N52 {
    /**
     * question 52.展平二叉搜索树
     */
    public static void main(String[] args) {
        N52 n = new N52();
        TreeNode node = TreeNodeUtil.deserialize("4,2,1,#,#,3,#,#,5,#,6,#,#");
        TreeNode flat = n.flat(node);
        List<Integer> list = TreeNodeUtil.preorderTraversal(flat);
        System.out.println("list = " + list);
    }

    // java的方法重载，参数列表有关，和返回值无关？对吗 对的，逻辑上看，为了避免调用的歧义。
    private TreeNode flat(TreeNode node) {
        //todo 数组的初始化
        TreeNode[] first = {null};
        TreeNode[] pre = {null};
        flat(node, first, pre);
        return first[0];
    }

    // keypoint 观察知道，展平结果是，树的节点，中序遍历顺序，通过right连接，头结点是中序遍历的第一个节点(最左边的节点)，
    // 定义，first,pre，遍历节点，给first,pre赋值，如果pre没有值，表示是第一个节点，有值的pre的left=null,right=node,操作完毕，node变成pre
    private void flat(TreeNode node, TreeNode[] first, TreeNode[] pre) {
        if (node != null) {
            flat(node.left, first, pre);
            if (pre[0] == null) {
                first[0] = node;
            } else {
                pre[0].left = null;
                pre[0].right = node;
            }
            pre[0] = node;
            flat(node.right, first, pre);
        }
    }

    // keypoint 如何判断，二叉树的遍历方法，是前序、中序、后序 遍历？【不管有无返回值，只看递归调用，和节点操作的位置关系】(应为从上到下执行）和返回值无关
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        //操作在中间
        System.out.println(root.val);
        int r = dfs(root.right);
        return 1;
    }
}
