class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

*/
public static Node reverseDLL(Node  head)
{
    if(head == null || head.next == null)
        return head;
    Node newHead = null;
    while(head != null){
        Node curr = head.next;
        head.next = newHead;
        head.prev = curr;
        newHead = head;
        head = curr;
    }
    
    return newHead;
}
