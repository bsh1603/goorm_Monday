package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_03 {
    static int N, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        ArrayList<Student> input = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            input.add(new Student("",0));
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            input.get(i).name = st.nextToken();
            input.get(i).height = Double.parseDouble(st.nextToken());
        }

//        for (int i = 0; i < input.size(); i++) {
//            System.out.printf(input.get(i).name + " " + input.get(i).height);
//            System.out.println("");
//        }

//        System.out.println("****");
        Collections.sort(input);
//        for (int i = 0; i < input.size(); i++) {
//            System.out.printf(input.get(i).name + " " + input.get(i).height);
//            System.out.println("");
//        }

        System.out.printf("%s %.2f", input.get(k-1).name, input.get(k-1).height);

    }

    static class Student implements Comparable<Student>{
        String name;
        double height;

        public Student(String name, double height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(Student o) {
            if(this.name.equals(o.name)){
                double c = this.height - o.height;
                if(c > 0){
                    return 1;
                }
                else if(c < 0){
                    return -1;
                }
                else{
                    return 0;
                }
            }
            else{
                return this.name.compareTo(o.name);
            }
        }
    }
}
