class Solution {
    // Function to calculate the span of stock's price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        ans[0] = 1;
        
        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && price[st.peek()] <= price[i]) {
                st.pop();
            }
            
            if (st.size() == 0) {
                ans[i] = i + 1;
            } else {
                ans[i] = i - st.peek();
            }
            
            st.push(i);
        }
        
        return ans;
    }
}
