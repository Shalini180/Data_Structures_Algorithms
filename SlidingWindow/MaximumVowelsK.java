class Solution {
    public int maxVowels(String s, int k) {
        TreeMap<Character, Integer> vowelMap = new TreeMap<>(Map.of(
            'a', 0,
            'e', 0,
            'i', 0,
            'o', 0,
            'u', 0
        ));

        int length = s.length();
        int start = 0, end = 0;
        int maxVowelCount = 0;
        int counter = 0;

        while (end < length) {
            char currentChar = s.charAt(end);
            int count = vowelMap.getOrDefault(currentChar, -1);
            if (count >= 0) {
                counter++;
                vowelMap.put(currentChar, count + 1);
            }

            if (end - start + 1 < k)
                end++;
            else if (end - start + 1 == k) {
                maxVowelCount = Math.max(maxVowelCount, counter);
                char startChar = s.charAt(start);
                int startCount = vowelMap.getOrDefault(startChar, -1);
                if (startCount > 0) {
                    vowelMap.put(startChar, startCount - 1);
                    counter--;
                }
                start++;
                end++;
            }        
        }

        return maxVowelCount;
    }
}
