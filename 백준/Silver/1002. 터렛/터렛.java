import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            double r1 = Double.parseDouble(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            double r2 = Double.parseDouble(st.nextToken());

            if(x1 == x2 && y1 == y2){
                if(r1 == r2) sb.append("-1").append("\n");
                else sb.append("0").append("\n");
            }else{
                double distance = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 -y2), 2));

                double diff = Math.abs(r1 - r2);

                if(distance > (r1 + r2)){
                    sb.append("0").append("\n");
                }else if(distance == (r1 + r2)){
                    sb.append("1").append("\n");
                }else if(distance < diff){
                    sb.append("0").append("\n");
                }else if(distance == diff){
                    sb.append("1").append("\n");
                }else{
                    sb.append("2").append("\n");
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
