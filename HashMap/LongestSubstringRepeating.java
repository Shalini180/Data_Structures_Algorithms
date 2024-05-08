class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int i = 0, j = 0;
        int n = s.length();
        int ans = 0;
        while(j < n){
            char eleJ = s.charAt(j);
            mp.put(eleJ, mp.getOrDefault(eleJ, 0) + 1);

            if(mp.size() == j - i + 1) ans = Math.max(ans, j - i + 1);
            else{
                while(mp.size() > 0 && mp.size() < j - i + 1){
                    char eleI = s.charAt(i);
                    int freqI = mp.get(eleI);
                    if(freqI == 1) mp.remove(eleI);
                    else{
                        mp.put(eleI, freqI - 1);
                    } 
                    i++;
                }
            }
            j++;
        }

        return ans;
    }
}
