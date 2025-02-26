import java.util.*;

class Solution {
    static Map<Integer, List<String>> data, rdata;
    static List<String> in, rin;
    
    public int[] solution(String[] words, String[] queries) {
        int wlen = words.length;
        int qlen = queries.length;
        int[] answer = new int[qlen];
        
        data = new HashMap<>();
        rdata = new HashMap<>();
        
        for(int i = 0; i < wlen; i++){
            String word = words[i];
            String rword = reverse(word);
            int totallen = word.length();
            
            if(!data.containsKey(totallen)){
                in = new ArrayList<>();
                in.add(word);
                rin = new ArrayList<>();
                rin.add(rword);
                data.put(totallen, in);
                rdata.put(totallen, rin);
            }else{
                data.get(totallen).add(word);
                rdata.get(totallen).add(rword);
            }
        }
        for(int len : data.keySet()){
            List<String> list = data.get(len);
            List<String> rlist = rdata.get(len);
            Collections.sort(list);
            Collections.sort(rlist);
        }
        
        
        for(int i = 0; i < qlen; i++){
            String query = queries[i];
            int totallen = query.length();
            
            List<String> wordList;
            if(query.charAt(0) == '?'){
                wordList = rdata.get(totallen);
                query = reverse(query);
            }else{
                wordList = data.get(totallen);
            }
            if(!data.containsKey(totallen)){
                answer[i] = 0;
                continue;
            }
            
            int s = 0, e = 0;
            String min = query.replace('?', 'a');
            String max = query.replace('?', 'z');
            s = search(wordList, min);
            e = search(wordList, max);
            answer[i] = e - s;
            
        }
        
        return answer;
    }
    static int search(List<String> wordList, String query){
        int s = 0;
        int e = wordList.size();
        while(s < e){
            int m = (s + e) / 2;
            if(query.compareTo(wordList.get(m)) >= 0){
                s = m + 1;
            }else{
                e = m;
            }
        }
        return s;
    }
    static String reverse(String s){
        return new StringBuffer(s).reverse().toString();
    }
}