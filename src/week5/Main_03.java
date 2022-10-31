package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_03 {
    static int N;
    static String[] input;
    static boolean[] visited;
    static String comb_str = "";
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new String[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = st.nextToken();
        }

        for (int i = 0; i < input.length; i++) {
            System.out.printf(input[i] + " ");
        }
        System.out.println("");

        visited = new boolean[N];

        dfs(0,0);
    }

    static void dfs(int depth, int index){
        if(depth == N){
            int num = Integer.parseInt(comb_str);
            answer = Math.min(answer, num);
            System.out.println(comb_str);
            comb_str = "";
        }

        for (int i = index; i < N; i++) {
            if(visited[i] == false){
                visited[i] = true;
                comb_str += input[i];
                dfs(depth+1, index+1);
                visited[i] = false;
            }
        }
    }
}
