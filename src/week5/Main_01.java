package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_01 {
    static int N, M;
    static int[][] map;
    static int[][] dist;
    static final int[] mx = {-1,1,0,0};
    static final int[] my = {0,0,-1,1};
    static ArrayList<Point> ant;
    static Queue<Point> queue;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ant = new ArrayList<>();
        answer = new ArrayList<>();
        queue = new LinkedList<>();
        map = new int[N][N];
        dist = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    ant.add(new Point(i,j));
                }
            }
        }

        for (int an = 0; an < ant.size(); an++) {
            queue.add(ant.get(an));

            while(!queue.isEmpty()){
                Point p = queue.poll();
                if(map[p.y][p.x] == 2){
                    answer.add(dist[p.y][p.x]);
                    initialize(dist);
                    queue.clear();
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int y = p.y + my[i];
                    int x = p.x + mx[i];

                    if(0<=x && x<N && 0<=y && y<N){
                        queue.offer(new Point(y, x));
                        dist[y][x] = dist[p.y][p.x] + 1;
                    }
                }
            }
        }

        int cnt = 0;
        for(int val : answer){
            if(val <= M){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void initialize(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;
            }
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
