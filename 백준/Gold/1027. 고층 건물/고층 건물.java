import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] buildings;

    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        buildings = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {

            int curHeigh = buildings[i];
            int sum = 0;
            float slope = Float.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (slope > ((float) (curHeigh - buildings[j]) / (i - j))) {
                    slope = ((float) (curHeigh - buildings[j]) / (i - j));
                    sum++;
                }
            }
            slope = Float.MAX_VALUE * (-1);
            for (int j = i + 1; j < N; j++) {
                if (slope < ((float) (buildings[j] - curHeigh) / (j - i))) {
                    slope = ((float) (buildings[j] - curHeigh) / (j - i));
                    sum++;
                }
            }
            result = Math.max(result, sum);
        }
        System.out.println(result);
        br.close();
    }
}
