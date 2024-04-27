/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node ptr = head;
        while(ptr != null){
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }
        
        ptr = head;
        while(ptr != null){
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        
        ptr = head;
        Node newHead = head.next;
        Node ptrNew = newHead;
        while (ptr != null) {
            ptr.next = ptr.next.next;
            ptrNew.next = (ptrNew.next != null) ? ptrNew.next.next : null;
            ptr = ptr.next;
            ptrNew = ptrNew.next;
        }

        return newHead;
    }
}
