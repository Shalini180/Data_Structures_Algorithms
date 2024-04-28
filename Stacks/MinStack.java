class MinStack {
    Stack<Integer> s1, s2;
    public MinStack() {
       s1 = new Stack<Integer>();
       s2 = new Stack<Integer>(); 
       s2.push(Integer.MAX_VALUE);    
    }
    
    public void push(int val) {
       if(s2.peek() >= val) s2.push(val);
       s1.push(val);
    }
    
    public void pop() {
        // System.out.println("D : " + s1.peek() + " " + s2.peek());
        if(s1.peek().equals(s2.peek())){
            s2.pop();
        }
        s1.pop();

        // System.out.println("E : " + s1.peek() + " " + s2.peek());
    }    
    public int top() {
        return (s1.size() > 0) ? s1.peek() : -1;
    }
    
    public int getMin() {
        System.out.println(s1.peek() + " " + s2.peek());
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
