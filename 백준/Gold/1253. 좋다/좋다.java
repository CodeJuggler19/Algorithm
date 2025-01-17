import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int result = 0;
        for (int i = 0; i < N; i++) {
            long target = arr[i];
            int left = 0;
            int right = arr.length - 1;
            while(left < right){
                if(left == i){
                    left ++;
                }else if(right == i){
                    right --;
                }else{
                    if(arr[left] + arr[right] == target){
                        result ++;
                        break;
                    }else if(arr[left] + arr[right] < target ){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        System.out.println(result);
        br.close();
    }


}
