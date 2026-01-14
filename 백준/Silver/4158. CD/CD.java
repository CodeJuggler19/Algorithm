import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N == 0 & M == 0) break;

            int result = 0;
            int[] list = new int[N];
            for(int i = 0; i < N; i++){
                list[i] = Integer.parseInt(br.readLine());
            }
            for(int i = 0; i < M; i++){
                int num = Integer.parseInt(br.readLine());
                int left = 0;
                int right = N - 1;
                while(left <= right){
                    int mid = (left + right) / 2;

                    if(list[mid] > num){
                        right = mid - 1;
                    }else if(list[mid] < num){
                        left = mid + 1;
                    }else{ // list[mid] == num
                        result ++;
                        break;
                    }
                }
            }
            System.out.println(result);
        }
        br.close();
    }
}
