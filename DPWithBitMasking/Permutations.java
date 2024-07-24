import java.util.*;

public class Main {
    public int setId(int a) {
        int cnt = 0;
        
        while (a > 0) {
            cnt++;
            a = a & (a - 1);
        }
        
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] rew = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rew[i][j] = sc.nextInt();
            }
        }
        
        int[] dp = new int[1 << n];
        Main mainObj = new Main(); // Create an object to call the non-static method
        
        for (int m = 0; m < (1 << n); m++) {
            int id = mainObj.setId(m) - 1;
            for (int i = 0; i < n; i++) {
                if (((m >> i) & 1) > 0) {
                    int curRew = rew[i][id];
                    int next = dp[m ^ (1 << i)];
                    dp[m] = Math.max(dp[m], curRew + next);
                }
            }
        }
        
        System.out.println("Answer :" + dp[(1 << n) - 1]);
    }
}
