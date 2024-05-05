class Solution {
    public int check(String haystack, String needle, int start){
        int end = start + needle.length() - 1;
        if(end >= haystack.length()) return -1;
        for(int i = start;i<=end;i++){
            if(haystack.charAt(i) != needle.charAt(i - start)) return -1;
        }
        return start;
    }
    public int strStr(String haystack, String needle) {
        for(int i = 0;i<haystack.length();i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                int ans = check(haystack, needle, i);
                if(ans != -1) return ans;
            }
        }

        return -1;
    }
}
