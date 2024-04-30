import java.util.Queue;
import java.util.LinkedList;

class MyStack {
    Queue<Integer> q;
    
    public MyStack() {
        q = new LinkedList<>();  
    }
    
    public void push(int x) {
        q.offer(x);
    }
    
    public int pop() {
        int size = q.size() - 1;

        while (size > 0) {
            int ele = q.poll();
            q.offer(ele);
            size--;
        }

        return q.poll();
    }
    
    public int top() {
        int size = q.size() - 1;
        
        while (size > 0) {
            int ele = q.poll();
            q.offer(ele);
            size--;
        }

        int ele = q.poll();
        q.offer(ele);
        return ele;
    }
    
    public boolean empty() {
        return (q.size() == 0);
    }
}
