class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mp = new HashMap<>();
        mp.put(')', '(');
        mp.put('}', '{');
        mp.put(']', '[');

        Stack st = new Stack();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
            }
            else if(st.size() > 0 && st.peek() == mp.get(s.charAt(i))){
                st.pop();
            }
            else{
                return false;
            }
        }

        return (st.size() == 0);
    }
}
