class MyHashMap {
    private final int INITIAL_SIZE = 16;
    private final double MAX_THRESHOLD = 0.75;
    private ArrayList<LinkedList<Pair<Integer,Integer>>> arr;
    int currSize, currBucket;

    private int hash(int key){
        return key % currBucket;
    }

    private double currLoad(){
        return currSize/(double)currBucket;
    }

    private void rehash(){
        currBucket *= 2;
        ArrayList<LinkedList<Pair<Integer,Integer>>> arr2 = new ArrayList<>();
        for(int i = 0;i<currBucket;i++){
            arr2.add(new LinkedList<>());
        }

        for(LinkedList<Pair<Integer,Integer>> ll : arr){
            Iterator<Pair<Integer,Integer>> it = ll.iterator();
            while(it.hasNext()){
                Pair<Integer,Integer> currPair = it.next();
                int newId = hash(currPair.getKey());
                arr2.get(newId).addFirst(new Pair<Integer, Integer>(currPair.getKey(), currPair.getValue()));
            }
        }

        arr = arr2;
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
            currSize += 1;
        }

        if(currLoad() > MAX_THRESHOLD)
            rehash();
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
            currSize -= 1;
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
