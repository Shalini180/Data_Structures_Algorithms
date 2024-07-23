/*

Definition for doubly Link List Node
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        if(head == null || head.next == null) return null;
        
        if(x == 1){
            Node next = head.next;
            next.prev = null;
            head = next;
            return head;
        }
        
        Node curr = head;
        while(curr != null && x != 1){
            curr = curr.next;
            x -= 1;
        }
        
        Node prev = curr.prev;
        Node next = curr.next;
        prev.next =
