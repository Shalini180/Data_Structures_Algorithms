class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    TreeMap<Integer, Integer> mp;
    TreeMap<Integer, Integer> levelMapping;
    public Solution(){
        mp = new TreeMap<>();
        levelMapping = new TreeMap<>();
    }
    public void helper(Node root, int vertical, int level){
        if(root == null) return;
        if(levelMapping.getOrDefault(vertical, 0) <= level){
            mp.put(vertical, root.data);
            levelMapping.put(vertical, level);
        }
        
        helper(root.left, vertical - 1, level + 1);
        helper(root.right, vertical + 1, level + 1);
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        helper(root, 0, 0);
        ArrayList<Integer> answer = new ArrayList<>();
        for(Map.Entry<Integer, Integer> it : mp.entrySet()) answer.add(it.getValue());
        return answer;
    }
}
