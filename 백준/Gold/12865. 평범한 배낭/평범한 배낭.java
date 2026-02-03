import java.io.*;
import java.util.*;

public class Main {
	static class Item implements Comparable<Item>{
		int weight;
		int value;
		
		Item(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
		
		@Override
		public int compareTo(Item item) {
			if(item.weight == this.weight) {
				return this.value - item.value;
			}else {
				return this.weight - item.weight;
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Item> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.add(new Item(w, v));
		}
		
		int[][] dp = new int[K + 1][N + 1];
		
		for(int i = 1; i <= K; i++) {
			for(int j = 1; j <= N; j++) {
				dp[i][j] = dp[i][j - 1];
				if(i - list.get(j - 1).weight >= 0) {
					dp[i][j] = Math.max(dp[i][j],   dp[i - list.get(j - 1).weight][j - 1] + list.get(j - 1).value);
				}
			}
		}
		
		System.out.println(dp[K][N]);
		
		br.close();
	}
}