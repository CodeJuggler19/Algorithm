import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] lect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lect = new int[N];
        st = new StringTokenizer(br.readLine());

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            lect[i] = Integer.parseInt(st.nextToken());
            sum += lect[i];
            max = Math.max(max, lect[i]);
        }
        int low = max;

        int high = sum;

        while (low < high) {
            int mid = (low + high) / 2;
            int num = check(mid);
            if (num <= M) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
        br.close();
    }

    static int check(int mid) {
        int limit = 0;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            if (limit + lect[i] > mid) {
                limit = lect[i];
                cnt++;
            }else{
                limit += lect[i];
            }
        }
        return cnt;
    }

}
