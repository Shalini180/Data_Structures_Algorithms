class Solution {
    public boolean isVowel(String word) {
        char startChar = word.charAt(0);
        char endChar = word.charAt(word.length() - 1);
        
        HashMap<Character, Integer> mp = new HashMap<>(Map.of(
            'a', 1,
            'e', 1,
            'i', 1,
            'o', 1,
            'u', 1
        ));

        return mp.containsKey(startChar) && mp.containsKey(endChar);
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] checkVowel = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                checkVowel[i] = checkVowel[i - 1];
            }
            if (isVowel(words[i])) {
                checkVowel[i] += 1;
            }
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int c = 0;
            int startIndex = queries[i][0];
            int endIndex = queries[i][1];
            c = checkVowel[endIndex];
            if (startIndex > 0) {
                c -= checkVowel[startIndex - 1];
            }
            ans[i] = c;
        }

        return ans;
    }
}
