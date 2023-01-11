package tree.trie;

import model.TrieMapNode;
import java.util.Scanner;

/*
    Trie implementation using Map (better memory utilization).
    Other implementation uses Array/List of size ALPHABETS instead of Map which can be useful for sorted output.

    Time Complexity: search/insert = O(n) - n being numbers of chars in string.
    Space Complexity : total nodes * ALPHABETS NUM * total chars
 */
public class TrieUsingMap {

    TrieMapNode root;

    public TrieUsingMap() {
        this.root = new TrieMapNode(null);
    }

    public void insert(String keyword){
        if (keyword == null || keyword.isBlank())
            return;

        TrieMapNode current = root;
        TrieMapNode prev = current;

        for (char c: keyword.toCharArray()){
            current.children.computeIfAbsent(c , TrieMapNode::new);
            current = current.children.get(c);
        }
        current.isWord = true;
    }

    public boolean search(String keyword){

        TrieMapNode current = root;

        for (char c: keyword.toCharArray()){
            current = current.children.get(c);
            if (current == null)
                return false;
        }

        return current.isWord;
    }

    public void display(StringBuilder keyword, TrieMapNode node){

        if(node.isWord){
            System.out.println(keyword);
        }

        if(node.children == null || node.children.isEmpty())
            return;

        for (TrieMapNode n : node.children.values()){
           display(keyword.append(n.value), n);
           keyword.deleteCharAt(keyword.length() - 1);
        }
    }

    public static void main(String[] args) {
        TrieUsingMap dictionary = new TrieUsingMap();
        Scanner sc = new Scanner(System.in);
        int input;
        String keyword;
        do {
            System.out.println("""
                    1-> insert
                    2-> search
                    3-> display all
                    0-> exit
                    """);
            input = sc.nextInt();
            sc.nextLine();
            switch (input){
                case 1 -> {System.out.println("Enter keyword"); keyword = sc.nextLine(); dictionary.insert(keyword);}
                case 2 -> {System.out.println("Enter keyword"); keyword = sc.nextLine();
                    System.out.println(dictionary.search(keyword));}
                case 3 -> dictionary.display(new StringBuilder(), dictionary.root);
                default -> System.out.println("Invalid input.");
            }
        }
        while (input != 0);
    }
}
