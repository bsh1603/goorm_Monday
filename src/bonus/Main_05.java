/**
 * 방 탈출하기
 */
package bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_05 {
    static int N, M;
    static int[] input;
    static int[] check;
    static boolean[] visited;
    static int NUM = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        check = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[NUM * 2 + 1];

        for (int i = 0; i < input.length; i++) {
            if(input[i] >= 0){
                visited[input[i]] = true;
            }
            else{
                visited[Math.abs(input[i]) + NUM] = true;
            }
        }

//        for (int i = 0; i < check.length; i++) {
//            if(check[i] >= 0){
//                if(visited[check[i]]){
//                    System.out.println("1");
//                }
//                else{
//                    System.out.println("0");
//                }
//            }
//            else{
//                if(visited[Math.abs(check[i]) + NUM]){
//                    System.out.println("1");
//                }
//                else{
//                    System.out.println("0");
//                }
//            }
//        }
    }
}
