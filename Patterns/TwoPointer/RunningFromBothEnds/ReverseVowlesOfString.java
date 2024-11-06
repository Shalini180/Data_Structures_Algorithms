class Solution {
    public boolean isVowel(Character ch){
        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'));
        return vowels.contains(ch);
    }
    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while(start <= end) {
            Character startChar = s.charAt(start);
            if(!isVowel(startChar)){
                start++;
                continue;
            }
            Character endChar = s.charAt(end);
            if(!isVowel(endChar)){
                end--;
                continue;
            }

            sb.setCharAt(start, endChar);
            sb.setCharAt(end, startChar);
            start++;
            end--;
        }

        return sb.toString();
    }
}
