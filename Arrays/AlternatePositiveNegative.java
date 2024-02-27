class Solution {
    void rearrange(int arr[], int n) {
       ArrayList<Integer> positive = new ArrayList<>();
       ArrayList<Integer> negative = new ArrayList<>();
       for(int i = 0;i<n;i++){
            if(arr[i] >= 0)
                positive.add(arr[i]);
            else
                negative.add(arr[i]);
       }
       
       int i = 0,j = 0, k = 0;
       while(i<positive.size() && j<negative.size()){
           arr[k++] = positive.get(i);
           i++;
           arr[k++] = negative.get(j);
           j++;
       }
       
       while(j < negative.size()){
           arr[k++] = negative.get(j);
           j++;
       }
       
       while(i < positive.size()){
           arr[k++] = positive.get(i);
           i++;
       }
    }
}
