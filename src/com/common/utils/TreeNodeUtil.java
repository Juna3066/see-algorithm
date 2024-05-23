package com.common.utils;

import com.common.enums.TraversalType;
import com.common.structure.TreeNode;

import java.util.*;

/**
 * todo 序列化、反序列化、 用二叉树的 广度优先遍历实现。层实现，图形呈现更直观。
 */
public class TreeNodeUtil {
    private static final String NULL_TREE_NODE_CHARACTER = "#";
    private static final String DELIMITER = ",";

    /**
     * 树的遍历
     * @param root 树的根节点
     * @param type 遍历类型 TraversalType枚举
     * @return  List<Integer>
     */
    public static List<Integer> traversal(TreeNode root, TraversalType type) {
        List<Integer> list = new LinkedList<>();
        type = type == null ? TraversalType.inorder : type;
        if (type == TraversalType.inorder) {
            inorderDFS(root, list);
        } else if (type == TraversalType.preorder) {
            preorderDFS(root, list);
        } else {
            postorderDFS(root, list);
        }
        return list;
    }

    //depth first search 深度优先搜索
    private static void inorderDFS(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorderDFS(root.left, list);
            list.add(root.val);
            inorderDFS(root.right, list);
        }
    }

    private static void preorderDFS(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preorderDFS(root.left, list);
            preorderDFS(root.right, list);
        }
    }

    private static void postorderDFS(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorderDFS(root.left, list);
            postorderDFS(root.right, list);
            list.add(root.val);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val); //opt
            cur = cur.right;
        }
        return list;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                list.add(cur.val); //opt
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }

    /*
     * keypoint 如果一个节点存在右子节点并且右子节点正好是前一个被遍历的节点，
     * 那么它的右子树已经遍历过，现在是时候遍历当前的节点了
     *
     * keypoint keypoint 如果变量cur指向的节点没有右子树或它的右子树已经遍历过，
     * 则按照后序遍历的顺序此时可以遍历这个节点，于是把它出栈并遍历它。
     * 下一个遍历的节点一定是它的父节点，而父节点之前已经存放到栈中，
     * 所以需要将变量cur重置为null，这样下一次就可以将它的父节点出栈并遍历
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        //Stack<TreeNode> stack = new Stack<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.offerLast(cur); //stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peekLast(); // cur = stack.peek();
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
            } else {
                stack.pollLast(); //stack.pop();
                list.add(cur.val);
                pre = cur;
                cur = null;
            }
        }
        return list;
    }

    /**
     * 把root代表的二叉树，通过前序遍历，序列化为，字符串
     *
     * @param root 二叉树根节点
     * @return 序列化得到的字符串
     */
    public static String serialize(TreeNode root) {
        if (root == null)
            return NULL_TREE_NODE_CHARACTER;
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + DELIMITER + left + DELIMITER + right;
    }


    /**
     * 字符串 反序列化为 二叉树
     *
     * @param str 二叉树，前序遍历，序列化，得到的字符串。
     * @return 代表二叉树的根节点
     */
    public static TreeNode deserialize(String str) {
        String[] array = str.split(DELIMITER);
        //int[] cur = new int[]{0};
        int[] cur = {0};
        return deserialize(array, cur);
    }

    private static TreeNode deserialize(String[] array, int[] cur) {
        String s = array[cur[0]++];
        if (NULL_TREE_NODE_CHARACTER.equals(s))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = deserialize(array, cur);
        node.right = deserialize(array, cur);
        return node;
    }

    /**
     * keypoint 二叉搜索树中查找，时间复杂度O(h),平常的二叉树的查找，时间复杂度O(n)
     * <p>
     * 二叉搜索树中，查找值是target的节点
     *
     * @param root   代表二叉搜索树的根节点
     * @param target 查找的目标值
     * @return 结果节点
     */
    public static TreeNode searchBinarySearchTree(TreeNode root, int target) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == target) break;
            cur = cur.val > target ? cur.left : cur.right;
        }
        return cur;
    }

}
