class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> mp = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);   
        }};
        
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ele = s.charAt(i);
            int value = mp.get(ele);
            if (i + 1 < s.length() && value < mp.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
