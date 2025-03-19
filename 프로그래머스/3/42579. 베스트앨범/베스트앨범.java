import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        String genre;
        int play, num;
        
        private Node(String genre, int play, int num){
            this.genre = genre;
            this.play = play;
            this.num = num;
        }
        
        @Override
        public int compareTo(Node node){
            if(this.play == node.play){
                return this.num - node.num;
            }else{
                return node.play - this.play;
            }
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, List<Node>> genreMap = new HashMap<>();
        Map<String, Integer> playMap = new HashMap<>();
        Set<String> genreSet = new HashSet<>();
        
        for(int i = 0; i < plays.length; i++){
            String genre = genres[i]; 
            int play = plays[i];
            
            if(!genreMap.containsKey(genre)){
                genreMap.put(genre, new ArrayList<>());   
            }
            List<Node> list = genreMap.get(genre);
            list.add(new Node(genre, play, i));
            
            if(!playMap.containsKey(genre)){
                playMap.put(genre, play);   
            }else{
                playMap.put(genre, playMap.get(genre) + play);   
            }
            
            if(!genreSet.contains(genre)){
                genreSet.add(genre);
            }
        }
        
        // System.out.println(playMap.isEmpty());
        // for(String genre : genreSet){
            // System.out.println(genre);
        // }
        
        List<Integer> result = new ArrayList<>();
        
        while(!playMap.isEmpty()){
            String maxGenre = "";
            int max = Integer.MIN_VALUE;
            for(String genre : genreSet){
                int play = playMap.get(genre);
                if(play > max){
                    max = play;
                    maxGenre = genre;
                }
            }
            List<Node> playList = genreMap.get(maxGenre);
            Collections.sort(playList);
            
            for(int i = 0; i < playList.size(); i++){
                if(i == 2) break;
                result.add(playList.get(i).num);
            }
            
            playMap.remove(maxGenre);
            genreSet.remove(maxGenre);
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}