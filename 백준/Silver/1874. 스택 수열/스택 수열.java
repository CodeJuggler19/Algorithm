import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> seq = new ArrayList<>();
        for(int i = 0; i < n; i++){
            seq.add(Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int cur = 1;
        int idx = 0;

        while(idx < n){
            if(cur > n + 1) break;
            if(!stack.isEmpty() && seq.get(idx).equals(stack.peek())){
                stack.pop();
                sb.append("-").append("\n");
                idx++;
            }else{
                stack.push(cur++);
                sb.append("+").append("\n");
            }
        }

        if(idx == n){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }

        br.close();
    }
}
