/**
 * 헷갈리는 작대기
 */

package bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_06 {
    static String input;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        count = new int[4];

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '1'){
                count[0]++;
            }
            if(input.charAt(i) == 'I'){
                count[1]++;
            }
            if(input.charAt(i) == 'l'){
                count[2]++;
            }
            if(input.charAt(i) == '|'){
                count[3]++;
            }
        }

        for(int val : count){
            System.out.println(val);
        }
    }
}
