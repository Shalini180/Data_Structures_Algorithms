class Solution {
    public int evaluate(int a, int b, String token){
        if(token.equals("+")) return a + b;
        else if(token.equals("-")) return a - b;
        else if(token.equals("/")) return a/b;
        return a * b;
    }
    public int evalRPN(String[] tokens) {
       Stack<Integer> st = new Stack<>();
       for(String token : tokens){
        if(token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")){
            int b = st.pop();
            int a = st.pop();
            st.push(evaluate(a, b, token));
        }
        else{
            st.push(Integer.parseInt(token));
        }
       }

       return st.peek();
    }
}
