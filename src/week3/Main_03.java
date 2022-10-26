package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_03 {
    static int N, M, K;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        count = new int[N+1];
        visited = new boolean[N+1];
        visited[1] = true;

        bfs();

        if(count[N] > K || count[N] == 0){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            if(tmp == N){
                break;
            }

            for (int i = 0; i < graph.get(tmp).size(); i++) {
                if(visited[graph.get(tmp).get(i)] == false){
                    visited[graph.get(tmp).get(i)] = true;
                    count[graph.get(tmp).get(i)] = count[tmp] + 1;
                    queue.offer(graph.get(tmp).get(i));
                }
            }
        }
    }
}
