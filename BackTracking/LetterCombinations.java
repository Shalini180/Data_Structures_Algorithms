class Solution {
    public void helper(int i, String digits, List<String> ans,  Map<Character, List<Character>> mp, StringBuilder str){
        if(i == digits.length()){
            ans.add(str.toString());
            return;
        }

        for(Character map : mp.get(digits.charAt(i))){
            str.append(map);
            helper(i+1, digits, ans, mp, str);
            str.setLength(str.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        Map<Character, List<Character>> mp = new HashMap<>();
        mp.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        mp.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        mp.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        mp.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        mp.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        mp.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        mp.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        mp.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        List<String> ans = new ArrayList<>();
        helper(0, digits, ans, mp, new StringBuilder());

        return ans;
    }
}
