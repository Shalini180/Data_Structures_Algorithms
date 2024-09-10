import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    ArrayList<Integer> ans; // Store all possible sums
    
    public Solution() {
        ans = new ArrayList<>();
    }

    // Helper method to calculate subset sums
    public void helper(ArrayList<Integer> arr, int i, int sum) {
        // Base case: If we've considered all elements, add the sum to the result
        if (i == arr.size()) {
            ans.add(sum);
            return;
        }
        
        // Exclude the current element
        helper(arr, i + 1, sum);
        
        // Include the current element
        helper(arr, i + 1, sum + arr.get(i));
    }

    // Main method to return the list of all subset sums
    public ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        helper(arr, 0, 0); // Start the recursive function
        return ans;        // Return the list of all sums
    }
}
