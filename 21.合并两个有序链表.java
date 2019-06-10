/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode index = new ListNode(-1);
        ListNode head = l1.val <= l2.val ? l1 : l2;

        ListNode index1 = l1;
        ListNode index2 = l2;
        while (index1 != null || index2 != null){
            if (index1 == null){
                index.next = index2;
                return head;
            }
            if (index2 == null){
                index.next = index1;
                return head;
            }
            while(index1 != null && index1.val <= index2.val){
                index.next = index1;
                index1 = index1.next;
                index = index.next;
            }
            while(index1 != null && index2 != null && index1.val > index2.val){
                index.next = index2;
                index2 = index2.next;
                index = index.next;
            }
        }
        return head;
    }

}

