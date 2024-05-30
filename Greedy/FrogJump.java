/******************************************************************************
 
                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main {
    public static void main(String[] args) {
        int n = 10;
        int k = 9;
        int[] d = {2, 1, 3, 1, 2, 1, 1, 1, 1, 1};  // Sample array, since the original was empty
        int curr = 0;  // Initializing the starting index
        int currDist = 0;  // Distance covered in the current segment
        int minJumps = 0;  // Minimum jumps needed

        while (curr < n) {
            int next = curr;
            while (next + 1 < n && currDist + d[next] <= k) {
                next += 1;
                currDist += d[next];
            }

            if (next == curr) break;  // If no progress, break the loop

            curr = next;
            minJumps += 1;
            currDist = 0;  // Reset distance for the next segment
        }

        System.out.println("Minimum jumps required: " + minJumps);
    }
}
