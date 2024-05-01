class Solution {
    public void nextSmaller(int[] heights, int[] ns){
        Stack<Integer> st = new Stack<>();
        for(int i = heights.length - 1;i >= 0;i--){
            int ele = heights[i];
            while(st.size() > 0 && heights[st.peek()] >= ele) st.pop();
            if(st.size() == 0) ns[i] = heights.length;
            else{
                ns[i] = st.peek();
            }
            st.push(i);
        }
    }
    public void prevSmaller(int[] heights, int[] ps){
         Stack<Integer> st = new Stack<>();
        for(int i = 0;i < heights.length;i++){
            int ele = heights[i];
            while(st.size() > 0 && heights[st.peek()] >= ele) st.pop();
            if(st.size() == 0) ps[i] = -1;
            else{
                ps[i] = st.peek();
            }
            st.push(i);
        }
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] ns = new int[n];
        int[] ps = new int[n];
        nextSmaller(heights, ns);
        prevSmaller(heights, ps);
        int maxi = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++)
            maxi = Math.max(maxi, (ns[i]-ps[i]-1)*heights[i]);
        
        return maxi;
    }
}
