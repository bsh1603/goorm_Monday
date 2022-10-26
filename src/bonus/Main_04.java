/**
 * 단어의 개수 세기
 */

package bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_04 {
    static ArrayList<Integer> input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        input = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            input.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(rsp(input));
    }

    static int rsp(ArrayList<Integer> list){
        int cnt = 0;
        int count_1 = 0;
        int count_2 = 0;
        int count_3 = 0;
        Collections.sort(list);
        if(list.contains(1)&& list.contains(2) && list.contains(3)){
            cnt = 0;
        }
        else if(list.get(0) == list.get(4)){
            cnt = 0;
        }
        else{
            for(int val : list){
                if(val == 1){
                    count_1++;
                }
                else if(val == 2){
                    count_2++;
                }
                else{
                    count_3++;
                }
            }
            if(!list.contains(1)){
                cnt += count_3;
            }
            else if(!list.contains(2)){
                cnt += count_1;
            }
            else if(!list.contains(3)){
                cnt += count_2;
            }
        }

        return cnt;
    }
}
