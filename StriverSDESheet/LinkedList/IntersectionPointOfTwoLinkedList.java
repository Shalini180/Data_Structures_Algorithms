/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode helper(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2;
        while(t1 != t2) {
            t1 = (t1 == null) ? l2 : t1.next;
            t2 = (t2 == null) ? l1 : t2.next;
        }

        return t1;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        return helper(headA, headB);
    }
}
