import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode indexNode = new ListNode(head.val);
        indexNode.next = head.next;

        nodes.add(head);
        while (indexNode.next != null) {
            indexNode = indexNode.next;
            nodes.add(indexNode);
        }

        int deleteIndex = nodes.size() - n - 1;
        if(deleteIndex < 0){
            return head.next;
        }
        ListNode preNode = nodes.get(deleteIndex);
        preNode.next = preNode.next.next;

        return head;
    }

}
