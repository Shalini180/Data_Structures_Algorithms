class Solution {
    public boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if(sLength != tLength) return false;
        Map<Character, Integer> mp = new HashMap<>();
        for(int i = 0; i < sLength;i++){
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }

        int size = mp.size();
        for(int i = 0;i < tLength; i++){
            Integer count = mp.get(t.charAt(i));
            if(count == null || count == 0) return false;
            count -= 1;
            if(count == 0) size -= 1;
            mp.put(t.charAt(i), count);
        }
        if(size == 0) return true;
        return false;
    }
}
