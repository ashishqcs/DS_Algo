package model;

import java.util.HashMap;
import java.util.Map;

public class TrieMapNode {

    public Map<Character, TrieMapNode> children;
    public boolean isWord;
    public Character value;

    public TrieMapNode(Character value){
        children = new HashMap<>();
        isWord = false;
        this.value = value;
    }

}
