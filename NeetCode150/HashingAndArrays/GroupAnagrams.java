class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String value : strs){
            char[] keyArr = value.toCharArray();
            Arrays.sort(keyArr);
            String key = new String(keyArr);
            List<String> list = mp.getOrDefault(key, new ArrayList<>());
            list.add(value);
            mp.put(key, list);
        }

        return new ArrayList<>(mp.values());
    }
}
