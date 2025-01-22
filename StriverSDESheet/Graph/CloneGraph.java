/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node helper(Node node, Map<Node, Node> mp){
        if(mp.containsKey(node)) return mp.get(node);

        Node clone = new Node(node.val);
        mp.put(node, clone);
        for(Node nei :  node.neighbors){
            clone.neighbors.add(helper(nei, mp));
        }

        return clone;
    }
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        return helper(node, new HashMap<>());
    }
}
