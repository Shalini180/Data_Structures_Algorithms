class Solution {
    public boolean isAlphaNumeric(Character ch){
        if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
            Character startChar = s.charAt(start);
            Character endChar = s.charAt(end); 
            if(!isAlphaNumeric(startChar)) {
                start++;
                continue;
            }
            if(!isAlphaNumeric(endChar)) {
                end--;
                continue;
            }
            if(Character.toUpperCase(startChar) != Character.toUpperCase(endChar)) return false;
            start++;
            end--; 
        }

        return true;
    }
}
