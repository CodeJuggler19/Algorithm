import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[100001];
        int [] count = new int[100001];
        
        prime[0] = prime[1] = true;

        for (int i = 2; i < 100001; i++) {
            if (prime[i]) {
                continue;
            }
            for (int j = i + i; j < prime.length; j = j + i) {
                prime[j] = true;
                int temp = j;
                while(temp % i == 0){
                    temp /= i;
                    count[j] ++;
                }
            }
        }
        int result = 0;
        for (int i = A; i <= B; i++){
            if(!prime[count[i]]) result++;
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
