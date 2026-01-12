import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> trees = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int len = Integer.parseInt(st.nextToken());
            max = Math.max(max, len);
            trees.add(len);
        }

        int left = 0;
        int right = max;

        while(left < right){
            int mid = (left + right) / 2;

            long sum = 0;

            for(int i = 0; i < trees.size(); i++){
                if(trees.get(i) > mid) sum += (trees.get(i) - mid);
            }

            if(M > sum){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(left - 1);
        br.close();
    }
}
