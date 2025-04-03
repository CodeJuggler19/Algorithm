import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i =0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long sum = 0;
        for(int i = 0; i < N; i++){
            A[i] -= B;
            sum ++;
            if(A[i] > 0){
                int temp = A[i] / C;
                sum += temp;
                A[i] -= (temp * C);
                if(A[i] > 0) sum++;
            }
        }
        System.out.println(sum);
        br.close();
    }
}
