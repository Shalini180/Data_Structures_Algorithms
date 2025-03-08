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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = new ListNode(head.val);
        ListNode dummy = newHead;
        while(head != null) {
            if(dummy.val == head.val){
                head = head.next;
                continue;
            }

            dummy.next = new ListNode(head.val);
            dummy = dummy.next;
            head = head.next;
        }

        return newHead;
    }
}
