/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode findMiddle(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
    ListNode findNewHead(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }
    public void reorderList(ListNode head) {
        ListNode middle = findMiddle(head);
        ListNode secondHead = middle.next;
        middle.next = null;
        ListNode newHead = findNewHead(secondHead);
        ListNode temp1 = head, temp2 = newHead;
        while(temp1 != null && temp2 != null){
            ListNode next = temp1.next;
            temp1.next = temp2;
            ListNode curr = temp2.next;
            temp2.next = next;
            temp1 = next;
            temp2 = curr;
        }
    }
}
