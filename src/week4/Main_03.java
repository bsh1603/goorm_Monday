package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_03 {
    static int N;
    static long[] dp;
    static long NUM = 100_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1];

        dp[0] = 0L;
        dp[1] = 5L;
        dp[2] = 17L;

        for (int i = 3; i <= N; i++) {
            dp[i] = (4*i + dp[i-1]*2) % NUM;
        }

        System.out.println(dp[N] + 1);
    }
}
