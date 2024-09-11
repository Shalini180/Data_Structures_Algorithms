class Solution {
    List<List<String>> ans;
    public Solution(){
        this.ans = new ArrayList<>();
    }
    public Boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public void helper(String s, int index, List<String> path){
        if(index == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = index;i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i + 1));
                helper(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        helper(s, 0, path);
        return ans;
    }
}
