class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charMp = new HashMap<>();
        int goodLength = 0;
        for(int i = 0;i < chars.length();i++){
            char ele = chars.charAt(i);
            charMp.put(ele, charMp.getOrDefault(ele, 0) + 1);
        }

        for(String word : words){
            Map<Character, Integer> wordMp = new HashMap<>();
            for(int i = 0;i<word.length();i++){
                char ele = word.charAt(i);
                wordMp.put(ele, wordMp.getOrDefault(ele, 0) + 1);
            }

            boolean flag = true;
            for(Map.Entry<Character, Integer> it : wordMp.entrySet()){
                char key = it.getKey();
                int value = it.getValue();
                if(charMp.get(key) == null){
                    flag = false;
                    break;
                }
                else if(charMp.get(key) < value) {
                    flag = false;
                    break;
                }
            }

            if(flag) goodLength += word.length();
        }

        return goodLength;
    }
}
