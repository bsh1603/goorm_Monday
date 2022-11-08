package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_04_re {
    static int N, M, K;
    static long[][] dp; // 남은경기수 , 구름이의구슬개수
    static final int MOD = 100000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new long[1001][201];

        for (int i = 0; i <= K; ++i) {
            for (int j = 0; j <= N+M; ++j) {
                dp[i][j] = dp[i][j] % MOD;
                // 1. 둘 중 하나라도 구슬 다 잃을 떄
                if(j == 0 || j == N+M){
                    dp[i][j] = 1L;
                }
                // 2. N+1 경기에서 구름이가 승리
                if(0 < j+1 && j+1 < N+M){
                    dp[i+1][j+1] += dp[i][j];
                }
                // 3. N+1 경기에서 무승부
                if(0 < j && j < N+M){
                    dp[i+1][j] += dp[i][j];
                }
                // 4. N+1 경기에서 구름이가 패배
                if(0 < j-1 && j-1 < N+M){
                    dp[i+1][j-1] += dp[i][j];
                }
            }
        }
        System.out.println(dp[K][N]);
    }
}
