class MyStack
{
    int top;
	int arr[] = new int[1000];

    MyStack()
	{
		top = -1;
	}
	
	//Function to push an integer into the stack.
    void push(int a)
	{
	    if(top >= 1000)
	        return;
	  
	    arr[++top] = a;
	} 
	
    //Function to remove an item from top of the stack.
	int pop()
	{
        if(top < 0)
            return -1;
        
        return arr[top--];
	}
	
	int top(){
	    if(top == -1) return -1;
	    return arr[top];
	}
	
	boolean isEmpty(){
	    if(top == -1) return true;
	    return false;
	}
	
	void clear(){
	    while(!isEmpty()){
	        top--;
	    }
	}
}
