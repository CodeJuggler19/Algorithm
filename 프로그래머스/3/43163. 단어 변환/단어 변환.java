import java.util.*;

class Solution {
    class Node{
        String word;
        int len;
        
        public Node(String word, int len){
            this.word = word;
            this.len = len;
        }
        String getWord(){
            return this.word;
        }
        int getLen(){
            return this.len;
        }
    }
    int answer;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(begin, 0));
        
        while(!q.isEmpty()){
            Node current = q.poll();
			// 추가한 부분
		    if(current.getLen() > words.length){
			    break;
		    }
            if(current.getWord().equals(target)){
                answer = current.getLen();
                break;
            }
            for(int i=0; i<words.length; i++){
                boolean check = checkWord(current.getWord(), words[i]);
                if(check){
                    q.add(new Node(words[i], current.getLen()+1));
                }
            }
        }
        
        return answer;
    }
    boolean checkWord(String a, String b){
        int cnt = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                cnt++;
            }
            if(cnt>1){
                break;
            }
        }
        if(cnt < 2){
            return true;
        }else{
            return false;
        }
    }
    
}