class MyHashMap {
    private final int INITIAL_SIZE = 16;
    private ArrayList<LinkedList<Pair<Integer,Integer>>> arr;
    int currSize, currBucket;
    private int hash(int key){
        return key % currBucket;
    }
    public MyHashMap() {
        arr = new ArrayList<LinkedList<Pair<Integer,Integer>>>(INITIAL_SIZE);
        currSize = 0;
        currBucket= INITIAL_SIZE;
        for(int i = 0;i<INITIAL_SIZE;i++) arr.add(new LinkedList<>());
    }
    
    public void put(int key, int value) {
        int i = hash(key);
        int keyId = get(arr.get(i), key);
        if(keyId == -1){
            arr.get(i).addFirst(new Pair<Integer, Integer>(key, value));
        }
        else{
            arr.get(i).set(keyId, new Pair<Integer, Integer>(key, value));
        }
    }
    
    private int get(LinkedList<Pair<Integer,Integer>> ll, int key) {
        Iterator<Pair<Integer, Integer>> it = ll.iterator();
        int index = 0;
        while(it.hasNext()){
            Pair<Integer, Integer> curPair = it.next();
            if(curPair.getKey() == key) return index;
            index++;
        }

        return -1;
    }
    public int get(int key) {
        int i = hash(key);
        Iterator<Pair<Integer, Integer>> it = arr.get(i).iterator();
        while(it.hasNext()){
            Pair<Integer, Integer> curPair = it.next();
            if(curPair.getKey() == key) return curPair.getValue();
        }

        return -1;
    }
    
    public void remove(int key) {
        int i = hash(key);
        int keyId = get(arr.get(i), key);
        if(keyId != -1){
            arr.get(i).remove(keyId);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
