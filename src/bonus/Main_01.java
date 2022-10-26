/**
 * 놀이공원
 */

package bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_01 {
    static int T;
    static int N, K;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N-K+1; i++) {
                for (int j = 0; j < N-K+1; j++) {
                    waste(new Point(i,j));
                }
            }
            System.out.print(answer);
        }
    }

    static void waste(Point start){
        int cnt = 0;
        for (int i = start.y; i < start.y + K; i++) {
            for (int j = start.x; j < start.x + K; j++) {
                cnt += map[i][j];
            }
        }
        answer = Math.min(answer, cnt);
    }

    static class Point{
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
















