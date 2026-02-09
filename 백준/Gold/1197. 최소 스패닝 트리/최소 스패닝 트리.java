import java.io.*;
import java.util.*;

public class Main {
	static int V;
	static int E;
	
	static int[] parent;
	static class Edge{
		int start;
		int end;
		int cost;
		
		Edge(int start, int end, int cost){
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	static List<Edge> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V + 1];
		for(int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.add(new Edge(start, end, cost));
		}
		
		Collections.sort(list, (e1, e2) ->  e1.cost - e2.cost);
		
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		int cost = 0;
		for(Edge e : list) {
			if(find(e.start) != find(e.end)) {
				cost += e.cost;
				union(e.start, e.end);
			}
		}
		System.out.println(cost);
		
		br.close();
	}
	
	static void union(int s, int e) {
		int sP = find(s);
		int eP = find(e);
		
		if(sP < eP) parent[eP] = sP;
		else parent[sP] = eP;
	}
	static int find(int n) {
		if(parent[n] == n) return n;
		else return parent[n] = find(parent[n]);
	}
}
