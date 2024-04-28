class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        Stack<Long> st = new Stack<>();
        long[] ans = new long[n];
        for(int i = n - 1;i>=0;i--){
            if(st.size() > 0 && st.peek() > arr[i]){
                ans[i] = st.peek();
            }
            else{
                while(st.size() > 0 && st.peek() <= arr[i]){
                    st.pop();
                }
                
                if(st.size() == 0)
                    ans[i] = -1;
                else
                    ans[i] = st.peek();
            }
            
            st.push(arr[i]);
        }
        
        return ans;
    } 
}
