import java.io.*;
import java.util.*;

public class Main {
	static int R;
	static int C;
	static char[][] board;
	static Set<Integer> alphabet = new HashSet<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R + 1][C + 1];
			
		for(int r = 1; r <= R; r++) {
			char[] inputs = br.readLine().toCharArray();
			for(int c = 1; c <= C; c++) {
				board[r][c] = inputs[c - 1];
			}
		}
		
		alphabet.add((int) board[1][1]);
		
		dfs(1, 1, 1);
		
		System.out.println(max);
		
		br.close();
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int max = Integer.MIN_VALUE;
	static void dfs(int r, int c, int depth) {
		
		if(max < depth) {
			max = depth;
		}
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr > 0 && nr <= R && nc > 0 && nc <= C
					&& !alphabet.contains((int) board[nr][nc])) {
				alphabet.add((int)board[nr][nc]);
				dfs(nr, nc, depth + 1);
				alphabet.remove((int)board[nr][nc]);
			}
		}
		
	}

}
