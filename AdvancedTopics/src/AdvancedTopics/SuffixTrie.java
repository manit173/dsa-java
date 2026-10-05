package AdvancedTopics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuffixTrie {
    private static class Node{
        Map<Character, Node> children = new HashMap<>();

        //starting positions of the substrings
        // that reahc this node
        List<Integer> positions = new ArrayList<>();
    }
    private final Node root =new Node();

    public SuffixTrie(String text){
         //strating one suffix from every position
        for(int start = 0; start<text.length();start++){
            Node current = root;

            //insert text[start ...end]
            for(int i = start;i<text.length();i++){
                char ch = text.charAt(i);
                Node child = current.children.get(ch);

                //crreate a branch if it doesnt exist
                if(child == null){
                    child = new Node();
                    current.children.put(ch, child);
                }
                current = child;

                //this substring occurs at 'start'
                current.positions.add(start);
            }
        }

    }
    public boolean contains(String pattern){
        return findNode(pattern) != null;
    }
    public List<Integer> occurrences(String pattern){
        Node node = findNode(pattern);
        if(node == null){
            return new ArrayList<>();
        }
        return node.positions;
    }
    private Node findNode(String pattern) {

        Node current = root;

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);

            current = current.children.get(ch);

            if (current == null) {
                return null;
            }
        }

        return current;
    }
    public static void main(String [] args){
        SuffixTrie trie = new SuffixTrie("banana");

        System.out.println(trie.contains("ana"));
        // true

        System.out.println(trie.occurrences("ana"));
        // [1, 3]

        System.out.println(trie.contains("nana"));
        // true

        System.out.println(trie.occurrences("nana"));
        // [2]

        System.out.println(trie.contains("band"));
        // false

    }

}
