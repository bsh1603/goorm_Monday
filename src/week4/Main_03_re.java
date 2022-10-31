/**
 * dp 문제
 * 윗 줄의 배치에 맨 아래줄의 가능한 배치의 경우의 수가 정해진다.
 *
 * 1줄 기준 -> 경우의 수 5가지(dp[1][1] ~ dp[1][5])
 *
 * 2줄
 * -> dp[2][1] = 1 + 2 + 3 + 4 + 5
 * -> dp[2][2] = 1 + 3 + 4
 * -> dp[2][3] = 1 + 2 + 4 + 5
 * -> dp[2][4] = 1 + 2 + 3
 * -> dp[2][5] = 1 + 3
 *
 * N줄
 * -> 위와 똑같지만 N-1줄의 dp값을 받아와 적용한다.
 */

package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_03_re {
    static int N;
    static long[][] dp;
    static int NUM = 100_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new long[N+1][6];
        for (int i = 1; i < 6; i++) {
            dp[1][i] = 1L;
        }

        for (int i = 2; i < N+1; i++) {
            dp[i][1] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][3] + dp[i-1][4] + dp[i-1][5]) % NUM;
            dp[i][2] = (dp[i-1][1] + dp[i-1][3] + dp[i-1][4]) % NUM;
            dp[i][3] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][4] + dp[i-1][5]) % NUM;
            dp[i][4] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][3]) % NUM;
            dp[i][5] = (dp[i-1][1] + dp[i-1][3]) % NUM;
        }

        long answer = 0;

        for (int i = 1; i <= 5; i++) {
            answer = answer + dp[N][i];
        }

        System.out.println(answer);

    }
}
