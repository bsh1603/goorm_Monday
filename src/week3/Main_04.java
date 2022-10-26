package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_04 {
    static int N;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int check = -1;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N+1];
        answer = new ArrayList<>();

        dfs(1, 1);

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int val : answer){
            System.out.print(val + " ");
        }
    }

    static void dfs(int start, int pre){
        // 방문 기록 있음
        if(visited[start] == true){
            check = start;
            if(!answer.contains(start)){
                answer.add(start);
            }
            return;
        }
        visited[start] = true;

        for (int i : graph.get(start)) {
            if(i == pre){
                continue;
            }
            dfs(i, start);

            // 값이 이미 순환고리에 있음
            if(check == -2){
                return;
            }
            if(check == start){
                check = -2;
                return;
            }
            if(check >= 0){
                if(!answer.contains(start)){
                    answer.add(start);
                }
                return;
            }
        }
    }
}
