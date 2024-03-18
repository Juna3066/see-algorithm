package com.sword2offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author JUN
 */
public class N46 {
    public static void main(String[] args) {
        N46 n = new N46();

        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);

        System.out.println(n.rightView(node1));

    }

    public List<Integer> rightView(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        if (node == null){
            return res;
        }

        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        current.offer(node);

        while (current.peek() != null) {
            TreeNode parent = current.poll();
            if (parent.getLeft() != null) {
                next.offer(parent.getLeft());
            }
            if (parent.getRight() != null) {
                next.offer(parent.getRight());
            }
            if (current.peek() == null) {
                //不一样的是下面 结果更新
                res.add(parent.getVal());
                //交替的代码固定
                current = next;
                next = new LinkedList<>();
            }
        }
        return res;
    }
}
