import java.util.*;

class Solution {
    class Node implements Comparable<Node>{ 
        int sum; // 작업량
        
        @Override
        public int compareTo(Node node){
            return node.sum - this.sum;
        }
        
        public Node(int sum){
            this.sum = sum;
        }
        
    }
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int work : works){
            pq.offer(new Node(work));
        }
        
        for(int i = 0; i < n; i++){
            if(pq.isEmpty()) break;
            Node cur = pq.poll();
            if(cur.sum > 1){
                pq.offer(new Node(cur.sum - 1));    
            }
            
        }
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            answer += (cur.sum * cur.sum);
        }
        
        return answer;
    }
}