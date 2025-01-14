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
 class Pair {
    ListNode temp;
    int count;
    public Pair(ListNode temp, int count){
        this.temp = temp;
        this.count = count;
    }
 }
class Solution {
    public Pair count(ListNode head){
        int c = 1;
        while(head.next != null) {
            c++;
            head = head.next;
        }

        return new Pair(head, c);
    }
    public ListNode helper(ListNode head, int k){
        Pair ans = count(head);
        int len = ans.count;
        ListNode last = ans.temp;
        last.next = head;
        k = k%len;
        for(int i = 1; i <= len - k; i++)
            last = last.next;
        ListNode temp = last.next;
        last.next = null;

        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        
        return helper(head, k);
    }
}
