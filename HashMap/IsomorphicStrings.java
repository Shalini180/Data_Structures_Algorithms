class Solution {
    public boolean isIsomorphic(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        if(sLength != tLength) return false;
        Map<Character, Character> mp = new HashMap<>();
        Map<Character, Character> tMp = new HashMap<>();
        for(int i = 0;i<sLength;i++){
            char sEle = s.charAt(i);
            char tEle = t.charAt(i);
            if(mp.get(sEle) != null && tMp.get(tEle) == null) return false;
            if(mp.get(sEle) == null && tMp.get(tEle) != null) return false;
            if(mp.get(sEle) != null && tMp.get(tEle) != null){
                if(mp.get(sEle) != tEle && tMp.get(tEle) != sEle) return false;
            }

            mp.put(sEle, tEle);
            tMp.put(tEle, sEle);
        }
        return true;
    }
}
