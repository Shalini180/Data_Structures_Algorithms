//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    static int topDownHelper(int n, int W, int[] wt, int[] val, int[][] dp){
        if(n == 0 || W == 0) return dp[n][W] = 0;
        if(dp[n][W] != -1) return dp[n][W];
        if(wt[n-1] <= W){
            return dp[n][W] = Math.max(val[n-1] + topDownHelper(n-1, W - wt[n-1], wt, val, dp), topDownHelper(n-1, W, wt, val, dp));
        }
        
        return dp[n][W] = topDownHelper(n-1, W, wt, val, dp);
    }
    static int bottomDownHelper(int n, int W, int[] wt, int[] val){
        int[][] dp = new int[n+1][W+1];
        
        for(int i = 0;i<=n;i++) dp[i][0] = 0;
        for(int j = 0;j<=W;j++) dp[0][j] = 0;
        
        for(int i = 1; i<=n;i++){
            for(int j = 1;j<=W;j++){
                if(j >= wt[i - 1]){
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j - wt[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][W];
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int[][] dp = new int[n+2][W+2];
        for(int i = 0;i<=n;i++) Arrays.fill(dp[i], -1);
        // return topDownHelper(n, W, wt, val, dp);
        return bottomDownHelper(n, W, wt, val);
        
    } 
}


