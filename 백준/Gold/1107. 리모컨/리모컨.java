import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean[] check = new boolean[10];
		if(M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				check[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		min = Math.abs(100 - N); 
		
		for(int i = 0; i <= 1000000; i++) {
			String numStr = String.valueOf(i);
			boolean yn = true;
			for(char num : numStr.toCharArray()) {
				if(check[num - '0']) {
					yn = false;
					break;
				}
			}
			
			if(yn) {
				int pow = numStr.length();
				int diff = Math.abs(N - i);
				min = Math.min(min, pow + diff);
			}
		}
		
		System.out.println(min);
			
		br.close();
	}
}