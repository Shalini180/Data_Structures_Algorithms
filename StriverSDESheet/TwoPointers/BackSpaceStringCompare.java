class Solution {
    public int getAlpha(String s, int ind) {
        int backspaceCount = 0;
        while (ind >= 0) {
            if (s.charAt(ind) == '#') {
                backspaceCount++; 
            } else if (backspaceCount > 0) {
                backspaceCount--; 
            } else {
                return ind; 
            }
            ind--; 
        }
        return -1; 
    }

    public boolean helper(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        
        while (i >= 0 || j >= 0) {  
            i = getAlpha(s, i);
            j = getAlpha(t, j);

            if (i < 0 && j < 0) return true;
            if (i < 0 || j < 0) return false;
            if (s.charAt(i) != t.charAt(j)) return false;

            i--;
            j--;
        }
        
        return true;
    }

    public boolean backspaceCompare(String s, String t) {
        return helper(s, t);
    }
}
