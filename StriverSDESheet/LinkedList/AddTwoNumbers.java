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
    public ListNode helper(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int s = 0; int c = 0;
        while(l1 != null || l2 != null) {
            s = 0;
            if(l1 != null){
                s += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                s += l2.val;
                l2 = l2.next;
            }

            s += c;
            temp.next = new ListNode(s%10);
            temp = temp.next;
            c = s / 10;
        }

        if(c != 0) temp.next = new ListNode(c);

        return dummy.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        return helper(l1, l2);
    }
}
