/*
 * https://www.youtube.com/watch?v=pkaooVBexeU
 * [208] Implement Trie (Prefix Tree)
 *
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 * 
 */
class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insert(word, 0);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root.find(word, 0);
        return node != null && node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root.find(prefix, 0);
        return node != null;
    }
}
class TrieNode {
    private TrieNode[] children;
    public boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }

    public void insert(String word, int index) {
        if (index == word.length()) {
            this.isWord = true;
            return;
        }
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            children[pos] = new TrieNode();
        }
        children[pos].insert(word, index + 1);
    }

    public TrieNode find(String word, int index) {
        if (index == word.length()) {
            return this;
        }

        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            return null;
        }
        return children[pos].find(word, index + 1);
    }
}
class TrieNodeII {
    private TrieNode[] children;
    public boolean hasWord;
    
    public TrieNode() {
        children = new TrieNode[26];
        hasWord = false;
    }
    
    public void insert(String word, int index) {
        if (index == word.length()) {
            this.hasWord = true;
            return;
        }
        
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            children[pos] = new TrieNode();
        }
        children[pos].insert(word, index + 1);
    }
    
    public TrieNode find(String word, int index) {
        if (index == word.length()) {
            return this;
        }
        
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            return null;
        }
        return children[pos].find(word, index + 1);
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root.find(word, 0);
        return (node != null && node.hasWord);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root.find(prefix, 0);
        return node != null;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

