/* Structure of linkedlist node
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
*/
class Solution
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x)
    {
        if(head == null || x < 1)
            return head;
        
        if(x == 1){
            Node newHead = head.next;
            if(newHead != null)
                newHead.prev = null;
            
            return newHead;
        }
        
        int i = 1;Node curr = head;
        while(curr != null && i < x){
            curr = curr.next;
            i++;
        }
        
        if(curr == null)
            return head;
        
        Node prevNode = curr.prev;
        Node lastNode = curr.next;
        prevNode.next = lastNode;
        if(lastNode != null)
        lastNode.prev = prevNode;
        
        return head;
    }
}
