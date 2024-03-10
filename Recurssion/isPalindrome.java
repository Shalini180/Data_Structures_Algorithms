class Solution {
    boolean helper(String s, int left, int right) {
        if (left > right)
            return true;
        
        if (s.charAt(left) != s.charAt(right))
            return false;
        
        return helper(s, left + 1, right - 1);
    }
    
    int isPalindrome(String S) {
        int n = S.length();
        if (helper(S, 0, n - 1))
            return 1;
        
        return 0;
    }
};
