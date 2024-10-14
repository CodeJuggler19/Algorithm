import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    Queue<Node> q = new LinkedList<>();
    
    public int solution(int[][] maps) {
        System.out.println(maps[0][0]);
        q.add(new Node(0,0,1));
        
        while(!q.isEmpty()){
            Node current = q.poll();    
            
            for(int i=0; i < 4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >= 0 && nx < maps.length && ny >= 0 && ny< maps[0].length){
                    if(maps[nx][ny] == 1){
                        maps[nx][ny] = current.value + 1;
                        q.add(new Node(nx, ny, maps[nx][ny]));    
                    }    
                }
            }
        }
        int answer = 0;
        if(maps[maps.length-1][maps[0].length-1] < 2){
            answer = -1;
        }else{
            answer = maps[maps.length-1][maps[0].length-1];
        }
        
        return answer;
    }
    public class Node{
        int x;
        int y;
        int value;
        
        public Node(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
        
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
        public int getValue(){
            return this.value;
        }
        
    }
    
    
}