package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_04_re {

    static int N, K;
    static int[][] map = new int[1004][1004];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            map[y1][x1]++;
            map[y1][x2]--;
            map[y2][x1]--;
            map[y2][x2]++;
        }

        // 가로 복원
        for (int i = 0; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] += map[i][j-1];
            }
        }

        // 세로 복원
        for (int j = 0; j < map.length; j++) {
            for (int i = 1; i < map[j].length; i++) {
                map[i][j] += map[i-1][j];
            }
        }

        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == K){
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
