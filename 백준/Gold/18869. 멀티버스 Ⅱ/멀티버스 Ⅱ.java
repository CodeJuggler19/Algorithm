import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new ArrayList<>());
            for(int j = 0; j < N; j++){
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < M; i++){
            result.add(compression(list.get(i)));
        }

        int answer = 0;
        for(int i = 0; i < M; i++){
            List<Integer> cur = result.get(i);
            for(int j = i + 1; j < M; j++){
                List<Integer> target = result.get(j);
                if(cur.equals(target)){
                    answer++;
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
    static List<Integer> compression(List<Integer> param){
        List<Integer> origin = new ArrayList<>(param);
        List<Integer> list = new ArrayList<>(new HashSet<>(param));

        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int val : list){
            if(!map.containsKey(val)){
                map.put(val, idx++);
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < origin.size(); i++){
            result.add(map.get(origin.get(i)));
        }

        return result;
    }

}
