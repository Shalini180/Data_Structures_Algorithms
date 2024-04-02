class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
class MyLinkedList {
    Node head;
    int length;
    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }
    
    public int get(int index) {
        if(index <0 || index >= length)
            return -1;
        Node curr = this.head;
        for(int i = 0;i<index;i++)
            curr = curr.next;
        
        return curr.data;
    }
    
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = this.head;
        this.head = newHead;
        this.length += 1;
    }
    
    public void addAtTail(int val) {
        if(length == 0){
            addAtHead(val);
            return;
        }

        Node temp = head;
        for(int i = 0;i<length-1;i++)
            temp = temp.next;
        temp.next = new Node(val);
        this.length += 1;
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > length){
            return;
        }

        if(index == 0){
            addAtHead(val);
            return;
        }

        Node curr = head;
        for(int i = 0;i<index - 1;i++)
            curr = curr.next;
        
        Node newNode = new Node(val);
        newNode.next = curr.next;
        curr.next = newNode;
        this.length += 1;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= length){
            return;
        }

        if(index == 0 && length != 0){
            Node secondNode = this.head.next;
            this.head = secondNode;
            this.length -= 1;
            return;
        }

        Node curr = this.head;
        for(int i = 0;i<index - 1;i++)
            curr = curr.next;
        
        curr.next = curr.next.next;
        this.length -= 1;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
