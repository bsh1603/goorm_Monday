package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_02 {
    static int N;
    static int[][] map;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static Queue<Point> queue;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        queue = new LinkedList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            if(check(map) == false){
                bfs();
            }
            else{
                break;
            }
        }

        System.out.println(cnt);
    }

    static void bfs(){
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] != 0){
                    visited[i][j] = true;
                    queue.offer(new Point(i, j));
                }
            }
        }

        while(!queue.isEmpty()){
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int y = p.y + my[i];
                int x = p.x + mx[i];

                if(0<=x && x<N && 0<=y && y<N){
                    if(map[y][x] == 0 && !visited[y][x]){
                        map[p.y][p.x]--;
                        if(map[p.y][p.x] == 0){
                            break;
                        }
                    }
                }
            }
        }
        cnt++;
    }

    static boolean check(int[][] arr){
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(map[i][j] != 0){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
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
