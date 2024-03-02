class Solution{
    int longestUniqueSubsttr(String S){
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = 0, j = 0;
        int n = S.length();
        int ans = 0;
        while(j < n){
            Character currElement = S.charAt(j);
            int count = mp.getOrDefault(currElement, 0);
            mp.put(currElement, count+1);
            if(mp.size() < j - i + 1){
                while(i < j && mp.size() != j-i+1){
                    char startElement = S.charAt(i);
                    int startCount = mp.get(startElement) - 1;
                    if(startCount == 0)
                        mp.remove(startElement);
                    else
                        mp.put(startElement, startCount);
                    i++;
                }
            }
            else if(mp.size() == j - i + 1){
                ans = Math.max(ans,j-i+1);
            }
            j++;
        }
        
        return ans;
    }
}
