import java.util.*;

class Solution {
    class Edge implements Comparable<Edge>{
        int num;
        int cost;
        
        Edge(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge edge){
            return this.cost - edge.cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<List<Edge>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < road.length; i++){
            int s = road[i][0];
            int e = road[i][1];
            int c = road[i][2];
            
            list.get(s).add(new Edge(e, c));
            list.get(e).add(new Edge(s, c));
        }
        
        boolean[] visited = new boolean[N + 1];
        int[] cost = new int[N + 1];
        
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        // 로직
        
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(1, 0));
        cost[1] = 0;
        
        while(!q.isEmpty()){
            Edge cur = q.poll();
            
            if(!visited[cur.num]){
                visited[cur.num] = true;
                
                for(Edge next : list.get(cur.num)){
                    if(!visited[next.num]){
                        if(cost[next.num] > cost[cur.num] + next.cost){
                            cost[next.num] = cost[cur.num] + next.cost;    
                            q.add(new Edge(next.num, cost[next.num]));
                        }
                    }
                }
            }
        }
        
        for(int i = 1; i <= N; i++){
            if(cost[i] <= K) answer ++;
        }

        return answer;
    }
}