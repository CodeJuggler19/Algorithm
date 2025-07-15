import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> set = new HashSet<>();
        int[] origin = new int[N];
        for(int i = 0; i < N; i++){
            int cur = Integer.parseInt(st.nextToken());
            origin[i] = cur;
            set.add(cur);
        }

        int[] list = new int[set.size()];
        int i = 0;
        for(Integer cur : set){
            list[i++] = cur;
        }
        Arrays.sort(list);

        Map<Integer, Integer> map = new HashMap<>();

        for(int j = 0; j < list.length; j++){
            map.put(list[j], j);
        }

        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < origin.length; j++){
            sb.append(map.get(origin[j])).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

}

