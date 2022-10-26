/**
 * 시간초과 이유 : 핸드폰 자판 배열을 입력받을 떄 이차원 배열(Character)로 설정
 * -> 일차원 배열(String)으로 입력받는다.
 */

package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_02_wrong {
    //핸드폰 자판 배열
    static String[] phone  =
            new String[]{"","1.,?!", "2ABC", "3DEF", "4GHI", "5JKL", "6MNO", "7PQRS", "8TUV", "9WXYZ"};
    static int n;
    static String s; // 명령

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine() + '.'; // 명령에 .을 추가해 마지막 숫자 명령까지 사용할 수 있도록 함

        StringBuilder sb = new StringBuilder();
        // 똑같은 숫자 몇번 눌렀나
        int cnt = 0;
        for (int i = 0; i < s.length()-1; i++) {
            // 뒤의 명령도 동일한 경우 cnt++
            if(s.charAt(i) == s.charAt(i+1)){
                cnt += 1;
                continue;
            }
            else{
                // 수행할 명령 order
                int order = Character.getNumericValue(s.charAt(i));
                cnt %= phone[order].length();
                sb.append(phone[order].charAt(cnt));
                cnt = 0;
            }
        }

        System.out.println(sb);

    }
}
