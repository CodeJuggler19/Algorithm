import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			char[] cmd = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
	        
	        LinkedList<Integer> deque = new LinkedList<>();
	        
	        str = str.replace("[", "").replace("]", "");
	        if(!str.isEmpty()) {
		        String[] arr = str.split(",");
		        for(String s : arr) {
		        	deque.add(Integer.parseInt(s));
		        }
	        }
	        
	        boolean reverse = false;  
	        boolean error = false;
	        
	        for(char c : cmd) {
	        	if(c == 'R') {
	        		reverse = !reverse;
	        	} else {  
	        		if(deque.isEmpty()) {
	        			error = true;
	        			break;
	        		}
	        		
	        		if(reverse) {
	        			deque.pollLast();
	        		} else {
	        			deque.pollFirst();
	        		}
	        	}
	        }
	        
	        if(error) {
	        	sb.append("error\n");
	        } else {
	        	sb.append("[");
	        	
	        	if(!deque.isEmpty()) {
	        		if(reverse) {
	        			sb.append(deque.pollLast());
	        			while(!deque.isEmpty()) {
	        				sb.append(",").append(deque.pollLast());
	        			}
	        		} else {
	        			sb.append(deque.pollFirst());
	        			while(!deque.isEmpty()) {
	        				sb.append(",").append(deque.pollFirst());
	        			}
	        		}
	        	}
	        	
	        	sb.append("]\n");
	        }
		}
		
		System.out.print(sb);
		br.close();
	}
}