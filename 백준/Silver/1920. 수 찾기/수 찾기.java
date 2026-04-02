import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        list[0] = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());

            if(binarySearch(target)){
                sb.append("1").append("\n");
            }else{
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
    public static boolean binarySearch(int target){
        int left = 1;
        int right = N;

        while(left <= right){
            int mid = (left + right) / 2;

            if(list[mid] > target){
                right = mid - 1;
            }else if(list[mid] < target){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
