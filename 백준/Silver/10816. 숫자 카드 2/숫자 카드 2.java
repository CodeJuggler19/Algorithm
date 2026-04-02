import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] cards;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());
            int lowerIdx = lowerBound(target);
            int upperIdx = upperBound(target);

            if(cards[lowerIdx] == target && cards[upperIdx] == target){
                sb.append(upperIdx - lowerIdx + 1).append(" ");
            }else if(cards[lowerIdx] != target && cards[upperIdx] != target){
                sb.append(0).append(" ");
            }else{
                sb.append(upperIdx - lowerIdx).append(" ");
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static int lowerBound(int target){
        int left = 0;
        int right = N - 1;

        while(left < right){
            int mid = (left + right) / 2;

            if(cards[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return right;
    }

    public static int upperBound(int target){
        int left = 0;
        int right = N - 1;

        while(left < right){
            int mid = (left + right) / 2;

            if(cards[mid] <= target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }

}
