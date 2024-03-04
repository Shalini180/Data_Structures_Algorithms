class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] prefix = new int[n];
        HashMap<Integer, Integer> carry = new HashMap<>(Map.of(1, 1, 0, -1));
        Arrays.fill(prefix, 0);
        
        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int direction = carry.get(shifts[i][2]);
            prefix[start] += direction;
            if (end < n - 1)
                prefix[end + 1] -= direction;
        }

        StringBuilder str = new StringBuilder();
        int pick = 0;
        for (int i = 0; i < n; i++) {
            if (prefix[i] != 0)
                pick += prefix[i];

            int currEle = (s.charAt(i) + pick);
            char newEle = (char) (((currEle - 'a') % 26 + 26) % 26 + 'a');

            str.append(newEle);
        }
        return str.toString();
    }
}
