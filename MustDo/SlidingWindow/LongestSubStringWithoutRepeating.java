class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int i = 0, j = 0;
        int maxi = 0;
        while(j < s.length()){
            char currChar = s.charAt(j);
            if(mp.get(currChar) != null){
                i = Math.max(mp.get(currChar) + 1, i);
            }

            mp.put(currChar, j);
            maxi = Math.max(maxi, (j - i + 1));
            j++;
        }

        return maxi;
    }
}
