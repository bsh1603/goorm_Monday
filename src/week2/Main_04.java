package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_04 {
    static int n;
    static int k; // 폭탄 개수
    static int[][] map;
    static final int[] mx = {-1, 1, 0, 0};
    static final int[] my = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;
            map[a][b]++;
            bomb(a,b);
        }

        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                answer += map[i][j];
            }
        }
        System.out.println(answer);
    }

    static int[][] bomb(int x, int y){
        for (int i = 0; i < 4; i++) {
            int px = x + mx[i];
            int py = y + my[i];

            if(0<=px && px<n && 0<=py && py<n){
                map[px][py]++;
            }
        }
        return map;
    }
}
