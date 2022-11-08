package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_03 {
    static int N;
    static int[] input;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    static int[] permute;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N];
        permute = new int[N];

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int depth){
        if(depth == N){
            int num = 0;
            for (int i = 0; i < permute.length; i++) {
                if(num % 10 == permute[i] / 10){
                    num = (num * 10 + permute[i] % 10);
                }
                else{
                    num = (num * 100 + permute[i]);
                }
            }
            answer = Math.min(answer, num);
        }

        for (int i = 0; i < input.length; i++) {
            if(visited[i] == false){
                visited[i] = true;
                permute[depth] = input[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}












