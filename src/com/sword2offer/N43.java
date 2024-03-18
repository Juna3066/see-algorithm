package com.sword2offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JUN
 */
public class N43 {
    public static void main(String[] args) {
        N43 n = new N43();

        CBTInsert cbtInsert = new CBTInsert(new TreeNode(1));
        System.out.println(cbtInsert.insert(2));
        System.out.println(cbtInsert.insert(3));
        System.out.println(cbtInsert.insert(4));
        System.out.println(cbtInsert.insert(5));
        System.out.println(cbtInsert.insert(6));
        System.out.println(cbtInsert.insert(7));
        System.out.println(cbtInsert.get_root());
    }
}

class CBTInsert {
    private TreeNode root;
    //队列 存的是 按树的广度优先遍历（层遍历）的【没有】 左右子节点的  【节点】。
    private Queue<TreeNode> queue;

    public CBTInsert(TreeNode root) {
        this.root = root;
        this.queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek().getLeft() != null &&queue.peek().getRight() != null){
            TreeNode parent = queue.poll();
            queue.offer(parent.getLeft());
            queue.offer(parent.getRight());
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode parent = queue.peek();

        if (parent.getLeft() == null) {
            parent.setLeft(node);
        } else if (parent.getRight() == null) {
            parent.setRight(node);
            queue.poll();
            queue.offer(parent.getLeft());
            queue.offer(parent.getRight());
        }
        return parent.getVal();
    }

    public int get_root() {
        return this.root.getVal();
    }
}
//todo 类的访问修饰符
class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        //todo 下面两句去除是否报错
        this.left = null;
        this.right = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
