import java.util.*;

class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        
        Map<String, Integer> nameMap = new HashMap<>();
        
        int[][] info = new int[friends.length][3];
        
        List<int[]> connect = new ArrayList<>();
        
        
        for(int i = 0; i < friends.length; i++){
            connect.add(new int[friends.length]);            
            
            String name = friends[i];
            nameMap.put(name, i);
        }
        
        for(int i = 0; i < gifts.length; i++){
            String[] names = gifts[i].split(" ");
            int senderKey = nameMap.get(names[0]);
            int receiverKey = nameMap.get(names[1]);
                        
            info[receiverKey][0] ++;
            info[senderKey][1] ++;
            
            int[] sender = connect.get(senderKey);
            sender[receiverKey] ++;
            int[] receiver = connect.get(receiverKey);
            receiver[senderKey] --;
        }
        
        for(int i = 0; i < friends.length; i++){
            info[i][2] = info[i][1] - info[i][0];
        }
        
        int answer = 0;
        
        // System.out.println(nameMap);
        for(int i = 0; i < friends.length; i++){
            int cnt = 0;
            
            String name = friends[i];
            int key = nameMap.get(name);
            int[] list = connect.get(key);
            for(int j = 0; j < friends.length; j++){
                if(i == j ) continue;
                String fname = friends[j];
                int fkey = nameMap.get(fname);
                
                if(list[fkey] > 0){
                    cnt ++;
                }else if(list[fkey] < 0){
                    continue;
                }else{
                    if(info[key][2] > info[fkey][2]) cnt++;
                }
            }
            // System.out.println(name + " : " + cnt);
            answer = Math.max(answer, cnt);
            // System.out.println(Arrays.toString(list));
        }
        
        
        
        return answer;
    }
}