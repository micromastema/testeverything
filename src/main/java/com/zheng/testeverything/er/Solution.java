package com.zheng.testeverything.er;

/**
 * @author zhengchentong on 2019/11/13
 */
public class Solution {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = addTwoNumbers(listNode1, listNode4);
        System.out.println(listNode);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int la = 1;
        int suma = 0;
        while (l1 != null) {
            suma = suma + (l1.val * la);
            la = la * 10;
            l1 = l1.next;
        }
        int lb = 1;
        int sumb = 0;
        while (l2 != null) {
            sumb = sumb + (l2.val * lb);
            lb = lb * 10;
            l2 = l2.next;
        }
        int sumc = suma + sumb;
        ListNode result = null;
        for (int i = (sumc + "").length(); i >= 0; i--) {
            result = new ListNode((int) (sumc % Math.pow(10L, i - 1)));
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}










