import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] note = new int[N];
            for(int i = 0; i < N; i++){
                note[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(note);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());


            for(int i = 0; i < M; i++){
                int num = Integer.parseInt(st.nextToken());
                int low = 0;
                int high = N - 1;
                boolean find = false;
                while(low <= high){
                    int mid = (low + high) / 2;
                    if(note[mid] == num){
                        find = true;
                        break;
                    }
                    if(note[mid] > num){
                        high = mid - 1;
                    }else{
                        low = mid + 1;
                    }
                }
                if(find){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}
