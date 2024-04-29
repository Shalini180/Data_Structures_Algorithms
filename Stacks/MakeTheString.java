class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ele = s.charAt(i);
            if (Character.isUpperCase(ele) && !st.isEmpty() && Character.isLowerCase(st.peek()) && Character.toUpperCase(st.peek()) == ele)
                st.pop();
            else if (Character.isLowerCase(ele) && !st.isEmpty() && Character.isUpperCase(st.peek()) && Character.toLowerCase(st.peek()) == ele)
                st.pop();
            else
                st.push(ele);
        }

        StringBuilder str = new StringBuilder();
        while (!st.isEmpty()) {
            str.append(st.pop());
        }

        return str.reverse().toString();
    }
}
