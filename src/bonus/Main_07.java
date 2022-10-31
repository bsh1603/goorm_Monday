/**
 * 뱀이 지나간 자리
 */

package bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_07 {
    static int N, M;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = '.';
            }
        }

        Point start = new Point(0,0);
        int cnt = 0;

        while(true){
            if(start.y >= N){
                break;
            }
            for (int i = 0; i < M; i++) {
                map[start.y][i] = '#';
            }

            if(start.y + 1 < N){
                if(cnt % 2 == 0){
                    map[start.y+1][M-1] = '#';
                }
                else{
                    map[start.y+1][0] = '#';
                }
            }
            start.y += 2;
            cnt++;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
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
