class Solution {

    public String encode(String s[]) {
        StringBuilder str = new StringBuilder();
        for(String value : s) {
            str.append(value.length()).append(":").append(value);
        }
        
        return str.toString();
    }

    public String[] decode(String s) {
        List<String> answer = new ArrayList<>();
        int i = 0;
        while(i < s.length()) {
            int colonIndex = s.indexOf(':', i);
            int len = Integer.parseInt(s.substring(i, colonIndex));
            String word = s.substring(colonIndex + 1, colonIndex + 1 + len);
            answer.add(word);
            i = colonIndex + 1 + len;
        }
        
         return answer.toArray(new String[0]);
        
    }
}
