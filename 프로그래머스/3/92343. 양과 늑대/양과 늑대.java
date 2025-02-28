import java.util.*;

class Solution {
    // static Map<Integer, List<Integer>> in;
    static List<Integer> in;
    static List<Set<Integer>> edgeList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    
    public int solution(int[] info, int[][] edges) {
    
        for(int i = 0; i < info.length; i++){
            edgeList.add(new HashSet<>());
        }
        for(int[] edge : edges){
            int s = edge[0];
            int e = edge[1];
            edgeList.get(s).add(e);
        }
   
        find(edgeList.get(0), 1, 0, info);
        int answer = max;
        return answer;
    }
    
    
    static void find(Set<Integer> list, int s, int w, int[] info){
        if(list.size() == 0){
            max = Math.max(max, s);
        } 
        
        for(int num : list){
            if(info[num] == 1){
                if(s > (w + 1)){
                    Set<Integer> newList = new HashSet<>(list);
                    for(int add : edgeList.get(num)){
                        newList.add(add);
                    }
                    newList.remove(num);
                    find(newList, s, w + 1, info);
                }
            }else{
                Set<Integer> newList = new HashSet<>(list);
                for(int add : edgeList.get(num)){
                    newList.add(add);
                }
                newList.remove(num);
                find(newList, s + 1, w, info);
            }
        }
        max = Math.max(max, s);
        
    }
    
}