package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_01_re {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Point> ant;
    static ArrayList<Point> water;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ant = new ArrayList<>();
        water = new ArrayList<>();
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    ant.add(new Point(i,j));
                }
                if(map[i][j] == 2){
                    water.add(new Point(i,j));
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < water.size(); i++) {
            for (int j = 0; j < ant.size(); j++) {
                if(visited[ant.get(j).y][ant.get(j).x] == false){
                    int result = calculate(ant.get(j), water.get(i));
                    if(result <= M){
                        visited[ant.get(j).y][ant.get(j).x] = true;
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    static int calculate(Point a, Point w){
        int distance = 0;
        distance = Math.abs(a.y - w.y) + Math.abs(a.x - w.x);

        return distance;
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
