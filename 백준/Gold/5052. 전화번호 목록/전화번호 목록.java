import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode{
        Map<Character, TrieNode> children;
        boolean end;

        public TrieNode(){
            this.children =new HashMap<>();
            this.end = false;
        }
    }
    static class Trie{
        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode node = root;
            for(char ch : word.toCharArray()){
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.end = true;
        }
        public boolean search(String word){
            TrieNode node = root;
            for(char ch : word.toCharArray()){
                if(!node.children.containsKey(ch)){
                    return false;
                }
                node = node.children.get(ch);
            }
            if(!node.children.isEmpty()){
                return false;
            }
            return true;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(t -- > 0){
            Trie trie = new Trie();
            int n = Integer.parseInt(br.readLine());
            String[] list = new String[n];
            int idx = 0;
            while(n -- > 0){
                String word = br.readLine();
                list[idx++] = word;
                trie.insert(word);
            }

            boolean check = false;
            for(String word : list){
                if(!trie.search(word)){
                    check = true;
                    break;
                }
            }
            if(check){
                sb.append("NO").append("\n");
            }else{
                sb.append("YES").append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }

}
