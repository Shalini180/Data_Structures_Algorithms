class Solution {
    public int minLength(String[] strs){
        int mini = Integer.MAX_VALUE;
        for(String word : strs) mini = Math.min(mini, word.length());
        return mini;
    }
    public String longestCommonPrefix(String[] strs) {
        int length = minLength(strs);
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i<length;i++){
            char currEle = strs[0].charAt(i);
            for(int j = 1;j<strs.length;j++){
                if(currEle != strs[j].charAt(i)) return ans.toString();
            }
            ans.append(currEle);
        }

        return ans.toString();
    }
}
