/**
 * queue가 아닌 deque을 이용한 풀이
 * 따로 배열에 입력값을 받는 게 아닌 입력값의 매 줄마다 로직을 진행한다.
 * 저축할 떄 reservation을 확인하는 로직이다.
 * deque이 비어있는지 계속 확인해야한다.(아니면 index 에러)
 */

package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_01_re {
    static int N, M;
    static String[] operation;
    static int[] num_oper;
    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        operation = new String[M];
        num_oper = new int[M];

        deque = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if(op.equals("deposit")){
                N += num;

                // deque가 비어있으면 index 에러가 나므로 확인해주어야한다.
                while(!deque.isEmpty() && deque.getFirst() <= N){
                    N -= deque.getFirst();
                    deque.pollFirst();
                }
            }

            else if(op.equals("pay")){
                if(N >= num){
                    N -= num;
                }
            }

            else if(op.equals("reservation")){
                if(deque.isEmpty() && N >= num){
                    N -= num;
                }
                else{
                    deque.add(num);
                }
            }
        }

        System.out.println(N);
    }
}
