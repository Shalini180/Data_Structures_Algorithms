import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            mp.put(a, mp.getOrDefault(a, 0) + 1);
        }

        int c = 0;
        boolean isOdd = false;
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            int key = entry.getValue();
            if (key % 2 == 0) {
                c += key;
            } else {
                isOdd = true;
                c += key - 1;
            }
        }

        if (isOdd) {
            c += 1;
        }
        return c;
    }
}
