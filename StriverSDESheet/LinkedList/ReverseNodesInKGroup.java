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
    public int count(ListNode head){
        int c = 0;
        while(head != null){
            c++;
            head = head.next;
        }

        return c;
    }
    public ListNode helper(ListNode head, int k) {
        int c = count(head);
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy, curr = dummy, next = dummy;
        while(c >= k){
            curr = prev.next;
            next = curr.next;
            for(int i = 1;i < k; i++){
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }

            prev = curr;
            c-=k;
        }

        return dummy.next;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;

        return helper(head, k);
    }
}
