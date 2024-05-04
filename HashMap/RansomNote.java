class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();
        for(int i = 0;i < ransomNote.length();i++) ransomMap.put(ransomNote.charAt(i), ransomMap.getOrDefault(ransomNote.charAt(i), 0) + 1);
        for(int i = 0;i < magazine.length(); i++) magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i), 0) + 1);
        for(Map.Entry<Character, Integer> entry : ransomMap.entrySet()){
            Character key = entry.getKey();
            int value = entry.getValue();
            if(magazineMap.get(key) == null) return false;
            if(magazineMap.get(key) < value) return false;
        }

        return true;
    }
}
