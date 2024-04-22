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
    void reverse(ListNode start, ListNode end){
        ListNode prev = null;
        ListNode curr = start;
        while(prev != end){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null || head.next == null) return head;
        
        ListNode start = head, end = head;
        int jump = k - 1;
        while(jump != 0){
            jump -= 1;
            end = end.next;
            if(end == null) return head;
        }

        ListNode rem_head = reverseKGroup(end.next, k);
        reverse(start, end);
        start.next = rem_head;
        return end;
    }
}
