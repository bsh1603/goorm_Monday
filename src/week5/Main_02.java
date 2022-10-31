package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_02 {
    static int N, M;
    static int[][] map;
    static final int[] mx = {-1,1,0,0};
    static final int[] my = {0,0,-1,1};
    static int answer = -1;
    static Queue<Point> water;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        water = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    water.offer(new Point(i, j));
                }
            }
        }

        bfs_water();

        System.out.println(answer);
    }

    static int[][] copy(){
        int[][] copy_map = new int[N][M];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                copy_map[i][j] = map[i][j];
            }
        }

        return copy_map;
    }

    static int bfs_water(){
        int day = 0;
        int cnt = 0;
        int size = water.size();
        while(!water.isEmpty()){
            Point p = water.poll();

            for (int i = 0; i < 4; i++) {
                int ny = p.y + my[i];
                int nx = p.x + mx[i];

                if(0<=nx && nx<M && 0<=ny && ny<N && map[ny][nx] == 1){
                    map[ny][nx] = 0;
                    water.offer(new Point(ny, nx));
                    cnt++;
                }
            }

            if(cnt == water.size()){
                day++;
                int[][] copy_map = copy();
                if(count(copy_map) >= 2){
                    answer = day;
                    break;
                }
                cnt = 0;
                size = water.size();
            }
        }
        return answer;
    }

    static void bfs_sand(int y, int x, int[][] arr){
        Queue<Point> sand = new LinkedList<>();
        sand.offer(new Point(y, x));

        while(!sand.isEmpty()){
            Point p = sand.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y + my[i];
                int nx = p.x + mx[i];

                if(0<=nx && nx<M && 0<=ny && ny<N && arr[ny][nx] == 1){
                    arr[ny][nx] = 0;
                    sand.offer(new Point(ny, nx));
                }
            }
        }
        
    }
    
    static int count(int[][] arr){
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1){
                    cnt++;
                    arr[i][j] = 0;
                    bfs_sand(i, j, arr);
                }
            }
        }
        return cnt;
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
