class Solution {
    public List<Integer> findAnagrams(String mainString, String pattern) {
        Map<Character, Integer> patternMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            int count = patternMap.getOrDefault(pattern.charAt(i), 0);
            patternMap.put(pattern.charAt(i), count + 1);
        }

        int start = 0, end = 0, length = mainString.length(), distinctCharacters = patternMap.size();
        int patternLength = pattern.length();
        List<Integer> indices = new ArrayList<>();

        while (end < length) {
            char currentChar = mainString.charAt(end);
            Integer occurrence = patternMap.get(currentChar);
            if (occurrence != null) { // Check if currentChar exists in the pattern
                if (occurrence == 1)
                    distinctCharacters -= 1;
                patternMap.put(currentChar, occurrence - 1);
            }

            if (end - start + 1 < patternLength)
                end++;
            else if (end - start + 1 == patternLength) {
                if (distinctCharacters == 0)
                    indices.add(start);

                Integer occurrenceOfStart = patternMap.get(mainString.charAt(start));
                if (occurrenceOfStart != null) { // Check if the character at start exists in the pattern
                    if (occurrenceOfStart == 0)
                        distinctCharacters += 1;
                    patternMap.put(mainString.charAt(start), occurrenceOfStart + 1);
                }
                start++;
                end++;
            }
        }

        return indices;
    }
}
