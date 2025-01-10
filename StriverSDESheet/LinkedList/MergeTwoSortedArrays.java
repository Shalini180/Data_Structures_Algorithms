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
        if(l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode res = l1;
        while(l1 != null && l2 != null){
            ListNode temp = null;
            while(l1 != null && l1.val <= l2.val) {
                temp = l1;
                l1 = l1.next;
            }

            temp.next = l2;

            ListNode curr = l1;
            l1 = l2;
            l2 = curr;
        }

        return res;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        return helper(list1, list2);
    }
}
