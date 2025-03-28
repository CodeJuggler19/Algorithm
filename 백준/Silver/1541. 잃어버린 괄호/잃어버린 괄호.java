import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<Integer> num = new ArrayList<>();
        List<Character> cal = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '+'){
                num.add(Integer.parseInt(String.valueOf(sb)));
                cal.add('+');
                sb = new StringBuilder();
            }else if(input.charAt(i) == '-'){
                num.add(Integer.parseInt(String.valueOf(sb)));
                cal.add('-');
                sb = new StringBuilder();
            }else{
                sb.append(input.charAt(i));
            }
            if(i == input.length() - 1){
                num.add(Integer.parseInt(String.valueOf(sb)));
            }
        }

        int sum = num.get(0);
        int temp = 0;
        boolean minus = false;
        for(int i = 0; i < cal.size(); i++){
            if(cal.get(i) == '-'){
                if(!minus){
                    sum += temp;
                }else{
                    sum -= temp;
                }
                minus = true;
                temp = num.get(i + 1);
            }else{
                temp += num.get(i + 1);
            }
        }
        if(minus){
            sum -= temp;
        }else{
            sum += temp;
        }
        System.out.println(sum);
        br.close();
    }
}
