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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode dummy = newHead;
        int c = 0;
        while(l1 != null && l2 != null){
            int s = l1.val + l2.val + c;
            c = s/10;
            dummy.next = new ListNode(s%10);

            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int s = l1.val + c;
            c = s/10;
            dummy.next = new ListNode(s%10);
            dummy = dummy.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int s = l2.val + c;
            c = s/10;
            dummy.next = new ListNode(s%10);
            dummy = dummy.next;
            l2 = l2.next;
        }

        if(c > 0)
            dummy.next = new ListNode(c);
        
        return newHead.next;
    }
}
