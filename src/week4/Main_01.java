package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_01 {
    static int N, M;
    static Operation[] input;
    static int total_money = 0;
    static ArrayList<Integer> reserve = new ArrayList<>();
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new Operation[M];
        for (int i = 0; i < M; i++) {
            input[i] = new Operation("", 0);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            input[i].order = st.nextToken();
            input[i].num = Integer.parseInt(st.nextToken());
        }

        queue = new LinkedList<>();

        total_money += N;

        for (int i = 0; i < M; i++) {
            if(input[i].order.equals("deposit")){
                total_money += input[i].num;
            }
            if(input[i].order.equals("pay")){
                if(total_money >= input[i].num){
                    total_money -= input[i].num;
                }
            }
            if(input[i].order.equals("reservation")){
                if(!queue.isEmpty()){
                    queue.offer(input[i].num);
                }
                else{
                    if(total_money >= input[i].num){
                        total_money -= input[i].num;
                    }
                    else{
                        queue.offer(input[i].num);
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            if(total_money >= tmp){
                total_money -= tmp;
            }
        }

        System.out.println(total_money);
    }

    static class Operation{
        String order;
        int num;

        public Operation(String order, int num) {
            this.order = order;
            this.num = num;
        }
    }
}
