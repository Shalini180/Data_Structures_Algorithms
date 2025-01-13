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
    public ListNode firstMiddle(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = null;
        while(head != null){
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }

        return temp;
    }
    public boolean helper(ListNode head){
        ListNode middle = firstMiddle(head);
        System.out.println(middle.val);
        ListNode fast = reverse(middle.next);
        middle.next = null;
        ListNode slow = head;

        while(fast != null){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        return helper(head);
    }
}
