class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        int[] hash = new int[26];
        int maxFreq = 0, maxLength = 0;
        while(j < n) {
            hash[s.charAt(j) - 'A'] += 1;
            maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);
            while(((j - i + 1) - maxFreq) > k){
                hash[s.charAt(i) - 'A'] -= 1;
                i++;
            }

            if(((j - i + 1) - maxFreq) <= k)
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }
}
