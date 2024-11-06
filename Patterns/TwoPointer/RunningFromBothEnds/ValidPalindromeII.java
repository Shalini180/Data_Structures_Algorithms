class Solution {
    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            Character startChar = s.charAt(start);
            Character endChar = s.charAt(end);
            if(startChar != endChar) return false;
            start++;
            end--;
        }

        return true;
    }
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }

            else{
                return isPalindrome(s, start+1, end) || isPalindrome(s, start, end-1);
            }
        }

        return true;
    }
}
