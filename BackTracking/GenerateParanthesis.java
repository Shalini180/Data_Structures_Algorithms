class Solution {
    public void helper(int ob, int cb, StringBuilder str, List<String> ans) {
        if (ob == 0 && cb == 0) {
            ans.add(str.toString());
            return;
        }

        if (ob > 0) {
            str.append('(');  // Add an open bracket
            helper(ob - 1, cb, str, ans);
            str.setLength(str.length() - 1);  // Backtrack
        }

        if (cb > ob) {
            str.append(')');  // Add a close bracket
            helper(ob, cb - 1, str, ans);
            str.setLength(str.length() - 1);  // Backtrack
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, n, new StringBuilder(), ans);
        return ans;
    }
}
