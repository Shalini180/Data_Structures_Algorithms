class StockPrice {
    HashMap<Integer, Integer> timeToPrice;
    TreeMap<Integer, Integer> priceToFreq;
    int latestTime;
    public StockPrice() {
        timeToPrice = new HashMap<>();
        priceToFreq = new TreeMap<>();
        latestTime = 0;
    }
    
    public void update(int timestamp, int price) {
        int lastPrice = timeToPrice.getOrDefault(timestamp, -1);
        timeToPrice.put(timestamp, price);
        latestTime = Math.max(latestTime, timestamp);

        if(lastPrice != -1){
            int prevFreq = priceToFreq.get(lastPrice);
            if(prevFreq <= 1) priceToFreq.remove(lastPrice);
            else priceToFreq.put(lastPrice, prevFreq - 1);
        }

        priceToFreq.put(price, priceToFreq.getOrDefault(price, 0) + 1); 
    }
    
    public int current() {
        return timeToPrice.get(latestTime);
    }
    
    public int maximum() {
        return priceToFreq.lastKey();
    }
    
    public int minimum() {
        return priceToFreq.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
