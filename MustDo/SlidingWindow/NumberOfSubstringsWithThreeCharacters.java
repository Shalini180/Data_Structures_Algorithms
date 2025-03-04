class Solution {
    public int numberOfSubstrings(String s) {
        int[] frequency = {-1, -1, -1};
        int count = 0;
        for(int i = 0; i < s.length();i++){
            Character currChar = s.charAt(i);
            frequency[currChar - 'a'] = i;
            count += Math.min(frequency[0], Math.min(frequency[1], frequency[2])) + 1;
        }

        return count;
    }
}
