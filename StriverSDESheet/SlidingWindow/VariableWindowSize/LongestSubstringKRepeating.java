class Solution {
    int calUnique(String s) {
        boolean[] check = new boolean[26];
        int unique = 0;
        for(int i = 0; i < s.length();i++){
            if(check[s.charAt(i) - 'a'] == false){
                unique++;
                check[s.charAt(i) - 'a'] = true;
            }
        }

        return unique;
    }
    public int helper(String s, int k){
        int maxUnique = calUnique(s);
        char[] str = s.toCharArray();
        int[] countMap = new int[26];
        int ans = 0;
        int n = str.length;
        for(int curr = 1; curr <= maxUnique; curr++){
            Arrays.fill(countMap, 0);
            int i = 0, j = 0;
            int countKLeast = 0;
            int unique = 0;
            while(j < n){
                if(unique <= curr){
                    int count = countMap[str[j] - 'a'];
                    if(count == 0) unique++;
                    countMap[str[j] - 'a']++;
                    if(countMap[str[j] - 'a'] == k) countKLeast++;
                    j++;
                }
                else{
                    int count = countMap[str[i] - 'a'];
                    if(count == k) countKLeast--;
                    countMap[str[i] - 'a']--;
                    if(countMap[str[i] - 'a'] == 0) unique--;
                   
                    i++;
                }

                if(unique == curr && unique == countKLeast)
                ans = Math.max(ans, (j - i));
            }

        }

        return ans;
    }
    public int longestSubstring(String s, int k) {
        return helper(s, k);
    }
}
