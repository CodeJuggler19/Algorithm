import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] trees;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        trees = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1000000000;
        while(left < right){
            int mid = (left + right + 1) / 2;

            long sum = calculate(mid);

            if(M <= sum){
                left = mid;
            }else{
                right = mid - 1;
            }

        }

        System.out.println(right);

        br.close();
    }

    public static long calculate(int height){
        long sum = 0;
        for(int i = 0; i < N; i++){
            if(trees[i] > height){
                sum += trees[i] - height;
            }
        }
        return sum;
    }
}
