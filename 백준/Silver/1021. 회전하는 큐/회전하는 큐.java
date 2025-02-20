import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++){
            dq.addLast(i);
        }
        st = new StringTokenizer(br.readLine());

        int result = 0;
        while(st.hasMoreTokens()){
            int c = Integer.parseInt(st.nextToken());
            int cnt = 0;
            while(dq.peekFirst() != c){
                cnt++;
                dq.addLast(dq.pollFirst());
            }
            if(dq.size() - cnt >= cnt){
                result += cnt;
                dq.pollFirst();
            }else{
                result += (dq.size() - cnt);
                dq.pollFirst();
            }
        }
        System.out.println(result);
        br.close();
    }
}
