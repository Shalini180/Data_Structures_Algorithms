class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mp = Map.of(']', '[', ')', '(', '}' , '{');
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') st.push(s.charAt(i));
            else if(mp.get(s.charAt(i)) != null){
                if(st.size() == 0) return false;
                if(st.size() > 0 && st.peek() != mp.get(s.charAt(i))) return false;
                st.pop();
            }
        }

        return st.size() == 0;
    }
}
