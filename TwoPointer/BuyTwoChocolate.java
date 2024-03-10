class Solution {
    public int buyChoco(int[] prices, int money) {
        int smallestPrice = Integer.MAX_VALUE, secondSmallestPrice = Integer.MAX_VALUE - 3;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= smallestPrice) {
                secondSmallestPrice = smallestPrice;
                smallestPrice = prices[i];
            } else if (prices[i] >= smallestPrice && prices[i] < secondSmallestPrice) {
                secondSmallestPrice = prices[i];
            }
        }

        int minCost = smallestPrice + secondSmallestPrice;
        if (minCost <= money)
            return money - minCost;
        
        return money;
    }
}
