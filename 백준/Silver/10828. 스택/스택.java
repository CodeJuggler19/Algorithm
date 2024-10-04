import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 스택 선언
        Stack<Integer> stack = new Stack<>();
        
        // 첫 번째 줄: 명령어의 수 N
        int N = Integer.parseInt(br.readLine());
        
        // N개의 명령어 처리
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            
            if (command.startsWith("push")) {
                // "push X" 명령 처리
                int X = Integer.parseInt(command.split(" ")[1]);
                stack.push(X);
            } else if (command.equals("pop")) {
                // "pop" 명령 처리
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.pop()).append("\n");
                }
            } else if (command.equals("size")) {
                // "size" 명령 처리
                sb.append(stack.size()).append("\n");
            } else if (command.equals("empty")) {
                // "empty" 명령 처리
                if (stack.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (command.equals("top")) {
                // "top" 명령 처리
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.peek()).append("\n");
                }
            }
        }
        
        // 결과 출력
        System.out.print(sb.toString());
    }
}
