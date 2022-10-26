/**
 * 전등 프로그래밍
 */

package bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_03 {
    static int n, m;
    static int p;
    static int[][] map;
    static Operation[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        p = Integer.parseInt(br.readLine());
        order = new Operation[p];

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            order[i] = new Operation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1);
        }

        for (int i = 0; i < p; i++) {
            change(map, order[i].select, order[i].num);
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static void change(int[][] arr, int order, int num){
        if(order == 1){
            for (int i = 0; i < n; i++) {
                if(arr[i][num] == 0){
                    arr[i][num] = 1;
                }
                else{
                    arr[i][num] = 0;
                }
            }
        }
        else{
            for (int i = 0; i < m; i++) {
                if(arr[num][i] == 0){
                    arr[num][i] = 1;
                }
                else{
                    arr[num][i] = 0;
                }
            }
        }
    }

    static class Operation{
        int select;
        int num;

        public Operation(int select, int num) {
            this.select = select;
            this.num = num;
        }
    }
}
