import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int l = 0, r = 0;
        int maxLen = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        while (r < n) {
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0) + 1);

            if (mp.size() > 2) {
                int count = mp.get(fruits[l]);
                if (count == 1) mp.remove(fruits[l]);
                else mp.put(fruits[l], count - 1);
                l++;  // Shrinking the window
            } else if(mp.size() <= 2) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++;
        }

        return maxLen;
    }
}
