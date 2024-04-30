class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    int first;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
        first = -1;
    }
    
    public void push(int x) {
        if(st1.size() == 0) first = x;
        st1.push(x);
    }
    
    public int pop() {
        while(st1.size() > 1){
            int ele = st1.pop();
            st2.push(ele);
        }

        int deleteEle = st1.pop();

        while(!st2.isEmpty()){
            int ele = st2.pop();
            push(ele);
        }

        return deleteEle;
    }
    
    public int peek() {
        return first;
    }
    
    public boolean empty() {
        return st1.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
