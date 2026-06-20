package SystemDesign;
import java.util.*;

class TrieNode {

    Map<Character, TrieNode> children;
    List<String> suggestions;
    boolean isWord;

    TrieNode() {
        children = new HashMap<>();
        suggestions = new ArrayList<>();
        isWord = false;
    }
}

class AutocompleteSystems {

    private TrieNode root;
    private int LIMIT = 5; // max suggestions

    public AutocompleteSystems() {
        root = new TrieNode();
    }

    // Insert word into Trie
    public void insert(String word) {

        TrieNode node = root;

        for(char c : word.toCharArray()) {

            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);

            if(node.suggestions.size() < LIMIT) {
                node.suggestions.add(word);
            }
        }

        node.isWord = true;
    }

    // Search suggestions
    public List<String> search(String prefix) {

        TrieNode node = root;

        for(char c : prefix.toCharArray()) {

            if(!node.children.containsKey(c)) {
                return new ArrayList<>();
            }

            node = node.children.get(c);
        }

        return node.suggestions;
    }
}
public class AutoCompleteSystem {

    public static void start(){
        AutocompleteSystems system = new AutocompleteSystems();

        system.insert("apple");
        system.insert("application");
        system.insert("apply");
        system.insert("appstore");
        system.insert("appetite");
        system.insert("banana");
        system.insert("band");
        system.insert("bank");

        System.out.println(system.search("app"));
        System.out.println(system.search("ban"));
        System.out.println(system.search("appl"));
    }
}