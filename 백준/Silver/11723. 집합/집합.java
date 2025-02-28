import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] s = new int[21];

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }

            if(command.equals("add")){
                s[num] = 1;
            }else if(command.equals("remove")){
                s[num] = 0;
            }else if(command.equals("check")){
                sb.append(s[num]).append("\n");
            }else if(command.equals("toggle")){
                if(s[num] == 1){
                    s[num] = 0;
                } else{
                    s[num] = 1;
                }
            }else if(command.equals("all")){
                Arrays.fill(s, 1);
            }else if(command.equals("empty")){
                Arrays.fill(s, 0);
            }else{
                System.out.println("Command is not available");
                return;
            }
        }
        System.out.println(sb);
        br.close();
    }

}
