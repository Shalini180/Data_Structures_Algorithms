/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class SortComparator implements Comparator<Item>{
    @Override
    public int compare(Item a, Item b){
        double r1 = (double)a.value/(double)a.weight;
        double r2 = (double)b.value/(double)b.weight;
        if(r1 < r2) return 1;
        else if(r1 > r2) return -1;
        return 0;
    }
}
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
       SortComparator sc = new SortComparator();
       Arrays.sort(arr, sc);
       double ans = 0;
       for(int i = 0;i<n;i++){
           if(arr[i].weight <= W){
               ans += arr[i].value;
               W = W - arr[i].weight;
           }
           else{
               double valuePerWeight = (double)(arr[i].value)/(double)(arr[i].weight);
               ans += valuePerWeight*W;
               break;
           }
       }
       
       return ans;
    }
}
