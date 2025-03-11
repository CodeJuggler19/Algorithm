import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num  = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            int idx = Integer.parseInt(st.nextToken());
            num[idx] = i;

        }

        int cnt = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < N; i++){
            if(num[i] < num[i + 1]){
                cnt ++;
            }else{
                max = Math.max(max, cnt);
                cnt = 1;
            }
        }
        int result = N - max;
        if(Integer.MIN_VALUE == max) result = 0;
        System.out.println(result);
        br.close();
    }
}
