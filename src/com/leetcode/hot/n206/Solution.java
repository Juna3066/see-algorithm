package com.leetcode.hot.n206;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    private void printListNode(ListNode head) {
        while (head != null) {
            System.out.println("head.val = " + head.val);
            head = head.next;
        }
    }



    public ListNode reverseList(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }

        ListNode resHead = null;
        for (int i = 0; i < vals.size(); i++) {
            if (i == 0) {
                resHead = new ListNode(vals.get(i), null);
            } else {
                ListNode node = new ListNode(vals.get(i), resHead);
                resHead = node;
            }
        }
        return resHead;
    }

    /**
     * 最后一个节点没有下一个
     * 头在移动
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode resHead = null;
        int count = 0;
        while (head != null) {
            if (count == 0) {
                resHead = new ListNode(head.val,null);
            } else {
                ListNode node = new ListNode(head.val,resHead);
                resHead = node;
            }
            head = head.next;
            count++;
        }
        return resHead;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1, new ListNode(2,new ListNode(3)));
        //printListNode(node);
        ListNode res = reverseList2(node);
        printListNode(res);
    }


}
