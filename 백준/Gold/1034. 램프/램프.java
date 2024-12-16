import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] inputs = new String[N];

        for(int i = 0; i < N; i++){
            inputs[i] = br.readLine();
        }

        int K = Integer.parseInt(br.readLine());

        Map<String, Integer> list = new HashMap<>();

        int max = 0;
        for(int i = 0; i < inputs.length; i++){
            char[] current = inputs[i].toCharArray();
            int cnt = 0;
            for(int j = 0; j < current.length; j++){
                if(current[j] == '0'){
                    cnt ++;
                }
            }

            if(cnt <= K && cnt % 2 == K % 2){
                list.put(inputs[i], list.getOrDefault(inputs[i], 0) + 1);
                max = Math.max(list.get(inputs[i]), max);
            }
        }
        bw.write(max + "");

        bw.flush();
        bw.close();
        br.close();
    }
}