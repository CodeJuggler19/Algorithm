import java.io.*;
import java.util.*;

public class Main{

    static Map<Integer, List<Integer>> people = new HashMap<>();
    static Map<Integer, List<Integer>> party = new HashMap<>();

    static boolean[] vis;
    static boolean[] known;

    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        vis = new boolean[M + 1];
        known = new boolean[N + 1];
        for(int i = 1; i <= N; i++){
            people.put(i, new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        if(num != 0){
            while(st.hasMoreTokens()){
                s.push(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            List<Integer> array = new ArrayList<>();
            int p;
            while(st.hasMoreTokens()){
                p =Integer.parseInt(st.nextToken());
                people.get(p).add(i);
                array.add(p);
            }
            party.put(i, array);
        }
//        System.out.println(people);
//        System.out.println(s);
//        System.out.println(party);

        while(!s.isEmpty()){
            int cur = s.pop();
            for(int ele : people.get(cur)){
                if(!vis[ele]){
                    vis[ele] = true;
                    M --;
                    for(int p : party.get(ele)){
                        if(p == cur) continue;
                        if(known[p]) continue;
                        known[p]= true;
                        s.push(p);
                    }
                }
            }
        }
        System.out.println(M);
        br.close();
    }
}
