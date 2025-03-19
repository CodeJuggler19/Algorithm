import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        int[] temp = new int[N];
        int l = 0;
        int sum = 0;
        for(int i = 0; i < N; i++){
            temp[i] = Integer.parseInt(st.nextToken());
            if(K > i){
                sum += temp[i];
            }
        }
        max = Math.max(max, sum);
        for(int i = K; i < N; i++){
            sum -= temp[l++];
            sum += temp[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);
        br.close();
    }
}
