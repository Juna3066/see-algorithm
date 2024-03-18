package com.sword2offer;

import java.util.*;

/**
 * @author JUN
 */
public class N47 {
    public static void main(String[] args) {
        N47 n = new N47();

        TreeSearch treeSearch = new TreeSearch();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        System.out.println(treeSearch.bfs(n1));
        System.out.println(treeSearch.dfsPre(n1));
        System.out.println(treeSearch.dfsIn(n1));
        System.out.println(treeSearch.dfsPost(n1));
    }
}

class TreeSearch {
    /**
     * 广度优先搜索 breathFirstSearch
     *
     * @param root
     * @return
     */
    public List<Integer> bfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode parent = queue.poll();
            res.add(parent.getVal());
            if (parent.getLeft() != null) {
                queue.offer(parent.getLeft());
            }
            if (parent.getRight() != null) {
                queue.offer(parent.getRight());
            }
        }
        return res;
    }

    public void dfsPreR(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.getVal());
            dfsPreR(node.getLeft(), res);
            dfsPreR(node.getRight(), res);
        }
    }

    /**
     * depthFirstSearchInReverse 递归特点，【遍历，以参数的形式，赋值。】
     *
     * @param node
     * @param res
     */
    public void dfsInR(TreeNode node, List<Integer> res) {
        if (node != null) {
            dfsInR(node.getLeft(), res);
            res.add(node.getVal());
            dfsInR(node.getRight(), res);
        }
    }

    public void dfsPostR(TreeNode node, List<Integer> res) {
        if (node != null) {
            dfsPostR(node.getLeft(), res);
            dfsPostR(node.getRight(), res);
            res.add(node.getVal());
        }
    }

    // 深度优先搜索，用递归，或者（迭代+stack实现）中序前序简单，后序略微复杂
    public List<Integer> dfsIn(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //双层while
        while (cur != null || !stack.empty()) {
            //下面while第一次结束，得到了一个 撇的栈。
            while (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            }
            //小捺
            cur = stack.pop();
            res.add(cur.getVal());
            cur = cur.getRight();
        }
        return res;
    }

    public List<Integer> dfsPre(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //双层while
        while (cur != null || !stack.empty()) {
            //下面while第一次结束，得到了一个 撇的栈。
            while (cur != null) {
                res.add(cur.getVal());
                stack.push(cur);
                cur = cur.getLeft();
            }
            //小捺
            cur = stack.pop();
            cur = cur.getRight();
        }
        return res;
    }

    public List<Integer> dfsPost(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //如果一个节点存在右子节点，且上一个便利的就是右子节点。那么这个节点，就可以遍历了。
        TreeNode pre = null;
        //双层while
        while (cur != null || !stack.empty()) {
            //下面while第一次结束，得到了一个 撇的栈。
            while (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            }
            //小捺
            cur = stack.peek();
            if (cur.getRight() != null && cur.getRight() != pre) {
                //还没遍历这个节点的右子节点
                cur = cur.getRight();
            } else {
                stack.pop();//去返回值
                res.add(cur.getVal());
                //cur = cur.getRight();
                pre = cur;
                cur = null;
            }
        }
        return res;
    }

}
