import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");

            if("push".equals(input[0])){
                q.addLast(Integer.parseInt(input[1]));
            }else if("pop".equals(input[0])){
                sb.append(q.isEmpty()? -1 : q.removeFirst()).append("\n");
            }else if("size".equals(input[0])){
                sb.append(q.size()).append("\n");
            }else if("empty".equals(input[0])){
                sb.append(q.isEmpty()? 1 : 0).append("\n");
            }else if("front".equals(input[0])){
                sb.append(q.isEmpty()? -1 : q.peekFirst()).append("\n");
            }else if("back".equals(input[0])){
                sb.append(q.isEmpty()? -1 : q.peekLast()).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}