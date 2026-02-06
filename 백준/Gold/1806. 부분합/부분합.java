import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> q = new LinkedList<>();
		
		int sum = 0;
		int len = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			sum += arr[i];
			q.addLast(arr[i]);
			
			while(sum >= S) {
				len = Math.min(len, q.size());
				
				if(sum - q.peek() < S) break;
				
				sum -= q.removeFirst();
			}
		}
		if(len == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(len);
		}
		br.close();
	}
}
