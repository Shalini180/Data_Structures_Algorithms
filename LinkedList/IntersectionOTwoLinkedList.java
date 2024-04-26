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
    public int getLength(ListNode head){
        int length = 0;
        ListNode dummy = head;
        while(dummy != null){
            length += 1;
            dummy = dummy.next;
        }

        return length;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int len1 = getLength(headA);
        int len2 = getLength(headB);
        int diff = len1 - len2;
        if(len1 < len2){
            ListNode temp = headA;
            headA = headB;
            headB = temp;
            diff = len2 - len1;
        }

        while(diff > 0){
            if(headA != null) 
                headA = headA.next;
            
            diff--;
        }

        while(headA != null && headB != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
