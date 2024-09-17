class Solution {
    static TreeMap<Integer, Integer> mp;
    static TreeMap<Integer, Integer> levelMapping;
    public Solution() {
        mp = new TreeMap<>();
        levelMapping = new TreeMap<>();
    }
    
    public static void helper(Node root, int vertical, int level){
        if(root == null) return;
        if(mp.containsKey(vertical) == false || levelMapping.get(vertical) > level){
            mp.put(vertical, root.data);
            levelMapping.put(vertical, level);
        }
        
        helper(root.left, vertical - 1, level + 1);
        helper(root.right, vertical + 1, level + 1);
    }


    static ArrayList<Integer> topView(Node root) {
        helper(root, 0, 0);
        ArrayList<Integer> answer = new ArrayList<>();
        for(Map.Entry<Integer, Integer> it : mp.entrySet()) answer.add(it.getValue());
        return answer;
    }
}
