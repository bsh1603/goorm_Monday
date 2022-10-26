package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_04 {
    static int N;
    static long NUM = 100_000_007;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1];

        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = (i * dp[i-1] - 1) % NUM;
        }

        System.out.println(dp[N]);
    }
}
