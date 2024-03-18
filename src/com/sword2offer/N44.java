package com.sword2offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 关键点， 重置，遍历下一层的时候， current= next; next =0;
 *
 * @author JUN
 */
public class N44 {
    public static void main(String[] args) {
        N44 n = new N44();

        //如何输入一个树结构，构造好一个树后，只需要输入根节点即可。
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(9);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setRight(node6);


        List<Integer> list = n.largestValues(node1);
        System.out.println("list = " + list);
    }

    /**
     * 层最大值，用双队列。
     * @param node
     * @return
     */
    public List<Integer> largestValues(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        //区分当前层 和 下一层元素
        int max = Integer.MIN_VALUE;

        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        if (node != null) {
            current.offer(node);
        }

        while (current.peek() != null) {
            //当前层出 判断最大值 下一层进
            TreeNode parent = current.poll();
            max = Math.max(max, parent.getVal());

            if (parent.getLeft() != null) {
                next.offer(parent.getLeft());
            }
            if (parent.getRight() != null) {
                next.offer(parent.getRight());
            }

            //当前层空，下层 给 当前层，新建下层。
            if (current.peek() == null) {
                list.add(max);
                max = Integer.MIN_VALUE;
                current = next;
                next = new LinkedList<>();
            }
        }

        return list;
    }
}
