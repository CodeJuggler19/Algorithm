import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] s = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            s[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(s);
        int result = s[0];
        for(int i = 1; i < N; i++){
            result += (s[i] - s[i - 1] + 1);
        }
        System.out.println(result);
        br.close();
    }
}
