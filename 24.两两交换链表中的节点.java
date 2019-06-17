/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode firstIndexNode = new ListNode(0);
        ListNode secondIndexNode = new ListNode(0);
        firstIndexNode = head;
        secondIndexNode = firstIndexNode.next;
        if (secondIndexNode != null) {
            head = secondIndexNode;
        }

        while (firstIndexNode != null && secondIndexNode != null) {
            firstIndexNode.next = secondIndexNode.next;
            secondIndexNode.next = firstIndexNode;

            if (firstIndexNode.next != null && firstIndexNode.next.next != null) {
                ListNode tempNode = firstIndexNode.next;

                firstIndexNode.next = firstIndexNode.next.next;

                firstIndexNode = tempNode;
            } else {
                firstIndexNode = firstIndexNode.next;
            }

            if (firstIndexNode != null) {
                secondIndexNode = firstIndexNode.next;
            }

        }

        return head;
    }
}

