class Solution {
    public static void helper(int i, int j, int[][] m, int n, ArrayList<String> ans, StringBuilder str){
        if(i == -1 || j == -1 || i == n || j == n || m[i][j] == 0) return;
        if(i == n - 1 && j == n - 1){
            ans.add(str.toString());
            return;
        }
        
        m[i][j] = 0;
        
        str.append('U');
        helper(i-1, j, m, n, ans, str);
        str.setLength(str.length() - 1);
        
        str.append('D');
        helper(i+1, j, m, n, ans, str);
        str.setLength(str.length() - 1);
        
        str.append('L');
        helper(i, j - 1, m, n, ans, str);
        str.setLength(str.length() - 1);
        
        str.append('R');
        helper(i, j + 1, m, n, ans, str);
        str.setLength(str.length() - 1);
        
        m[i][j] = 1;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        helper(0, 0, m, n, ans, new StringBuilder());
        return ans;
    }
}
