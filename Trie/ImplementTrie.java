class TrieNode{
    TrieNode[] children;
    boolean flag;

    public TrieNode(){
        children = new TrieNode[26];
        Arrays.fill(children, null);
        flag = false;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0;i<word.length();i++){
            Integer pos = word.charAt(i) - 'a';
            if(node.children[pos] != null){
                node = node.children[pos];
            }
            else{
                node.children[pos] = new TrieNode();
                node = node.children[pos];
            }
        }
        node.flag = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0;i<word.length();i++){
            Integer pos = word.charAt(i) - 'a';
            if(node.children[pos] == null) return false;
            node = node.children[pos];
        }
        return node.flag;  
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0;i < prefix.length();i++){
            Integer pos = prefix.charAt(i) - 'a';
            if(node.children[pos] == null) return false;
            node = node.children[pos];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
