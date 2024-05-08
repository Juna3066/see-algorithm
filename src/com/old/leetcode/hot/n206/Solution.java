package com.old.leetcode.hot.n206;

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

    /***
     * @param head
     * @return
     */
    public ListNode officialReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur!=null){
            ListNode next = cur.next;
            //当前的下一个指向 前一个没有被结构保存的数据 下一个再迭代要用，因此提前保存
            cur.next = pre;

            //移动
            //当前变成 前元素
            pre = cur;
            //当前的指向下一个
            cur = next;
        }
        //便利结束 pre是最后一个 cur是空
        return pre;
    }

    public ListNode officialReverseList2(ListNode head){
        //结尾变头 结尾next==null
        if (head==null || head.next == null){
            return head;
        }
        //返回的一直是尾节点作为头的 主键增长的反项链
        ListNode newHead = officialReverseList2(head.next);
        //当前后一个的下一个指向当前  箭头反向
        head.next.next = head;
        //当前下一个指控 否则形成闭环
        head.next = null;
        return newHead;
    }


    @Test
    public void test() {
        ListNode node = new ListNode(1, new ListNode(2,new ListNode(3)));
        //printListNode(node);
        ListNode res = officialReverseList2(node);
        printListNode(res);
    }


}
