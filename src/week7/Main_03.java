/**
 * 33 / 40
 * fail
 */

package week7;

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
    static int[] distance;
    static Queue<Integer> queue;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 섬의 개수
        M = Integer.parseInt(st.nextToken()); // 다리의 개수
        K = Integer.parseInt(st.nextToken()); // 구름이 시작 위치
        
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }


        queue = new LinkedList<>();
        distance = new int[N+1];

        bfs();

        if(flag){
            System.out.println(distance[K]);
        }
        else{
            System.out.println(-1);
        }

    }

    static void bfs(){

        queue.offer(K);

        while (!queue.isEmpty()){
            int tmp = queue.poll();

            for (int i = 0; i < graph.get(tmp).size(); i++) {
                queue.offer(graph.get(tmp).get(i));
                distance[graph.get(tmp).get(i)] = distance[tmp] + 1;
                if(graph.get(tmp).get(i) == K){
                    flag = true;
                    return;
                }
            }
        }
    }
}
