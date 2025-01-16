import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr= new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();


        for(int i=0; i<m; i++) {
            st= new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int lower = lowerBound(arr, start);

            int upper = upperBound(arr, end);

            sb.append(upper - lower).append("\n");
        }

        System.out.println(sb);

    }

    private static int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while(low<high) {
            int mid = (low+high)/2;
            if(arr[mid]>= target) {
                high = mid;
            }
            else {
                low = mid+1;
            }
        }

        return low;
    }

    private static int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while(low<high) {
            int mid = (low+high)/2;
            if(arr[mid] <= target) {
                low = mid+1;
            }
            else {
                high = mid;
            }
        }

        return low;
    }
}