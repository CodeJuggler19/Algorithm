import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());
            int lo = 0;
            int hi = N - 1;
            boolean check = false;
            while(lo <= hi){
                int mid = (lo + hi) / 2;
                if(A[mid] == target){
                    check = true;
                    break;
                }else if(A[mid] > target){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }
            if(check){
                sb.append("1 ");
            }else{
                sb.append("0 ");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
