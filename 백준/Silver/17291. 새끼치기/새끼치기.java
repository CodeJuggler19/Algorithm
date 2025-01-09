import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> bugs = new LinkedList<>();

        bugs.add(3);

        for(int i = 2; i <= N; i++){
            int size = bugs.size();
            for(int j = 0; j < size; j++){
                int cur = bugs.poll();
                if(i % 2 == 0){
                    bugs.add(4);
                }else{
                    bugs.add(3);
                }
                if(cur > 1){
                    bugs.add(cur - 1);
                }
            }
        }

        System.out.println(bugs.size());
        br.close();
    }
}
