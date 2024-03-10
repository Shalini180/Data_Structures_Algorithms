class Solution {
    public void reverseString(char[] s) { 
        int length = s.length;
        reverseHelper(s, 0, length - 1);
    }
    
    public void reverseHelper(char[] s, int left, int right) {
        if (left >= right)
            return;
        
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        reverseHelper(s, left + 1, right - 1);
    }
}
