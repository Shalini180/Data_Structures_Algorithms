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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode head : lists) {
            if(head != null) pq.add(head);
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(pq.size() != 0){
            ListNode curr = pq.poll();
            temp.next = curr;
            temp = temp.next;
            if(curr.next != null) {
                pq.add(curr.next);
            }
        }

        return dummy.next;
    }
}
