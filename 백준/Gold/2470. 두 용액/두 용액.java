import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int answer_1 = 0;
        int answer_2 = 0;

        int low = 0;
        int high = n - 1;

        int result = Integer.MAX_VALUE;

        while (low < high) {
            int sum = num[low] + num[high]; 
            if ( Math.abs(sum) < result) {
                result = Math.abs(sum);
                answer_1 = num[low];
                answer_2 = num[high];
            }

            if (sum < 0) {
                low++;
            } else {
                high--;
            }
        }

        System.out.println(answer_1 + " " + answer_2);
    }
}
