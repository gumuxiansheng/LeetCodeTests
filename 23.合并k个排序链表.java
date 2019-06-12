/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 * Assume there is n linked list and each list contains m nodes, the time complexity is O(n*m), the space complexity is O(n*m).
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0){
            return null;
        }

        ListNode indexNode = new ListNode(0);
        ListNode firstNode = indexNode;

        int minI = 0;
        while (minI >= 0) {
            indexNode.next = lists[0];
            minI = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (indexNode.next == null || lists[i].val <= indexNode.next.val) {
                    minI = i;
                    indexNode.next = lists[minI];
                }
            }

            if (minI >= 0) {
                lists[minI] = lists[minI].next;
                indexNode = indexNode.next;
            }
        }

        return firstNode.next;
    }

}
