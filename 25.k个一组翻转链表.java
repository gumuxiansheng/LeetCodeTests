/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] k个一组翻转链表
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) {
            return head;
        }

        ListNode p = new ListNode(0);
        ListNode q = new ListNode(0);
        ListNode l = new ListNode(0);
        ListNode m = new ListNode(0);
        ListNode n = new ListNode(0);

        p.next = head;
        q.next = head;
        l.next = head;
        m.next = head;
        n.next = head;

        int index = 0;
        for (; index < k && q.next != null; index++) {
            q.next = q.next.next;
        }

        if (index == k) {
            l.next = l.next.next;
            m.next = l.next.next;
            n.next = l.next.next;

            l.next.next = p.next;

            for (int i = 1; i < k - 1; i++) {
                if (m.next != null) {
                    n.next = m.next.next;
                    m.next.next = l.next;
                    l.next = m.next;
                    m.next = n.next;

                }

            }

            head = l.next;

            p.next.next = reverseKGroup(q.next, k);
        }

        return head;
    }
}

