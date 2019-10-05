/*
211. Add and Search Word - Data structure design
https://www.jiuzhang.com/solution/add-and-search-word-data-structure-design/
*/

class AddAndSearchWord {
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (now.children[c - 'a'] == null) {
                now.children[c - 'a'] = new TrieNode();
            }
            now = now.children[c - 'a'];
        }
        now.hasWord = true;
    }

    private boolean find(String word, int index, TrieNode now) {
        if (index == word.length()) {
            return now.hasWord;
        }

        Character c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (now.children[i] != null) {
                    if (find(word, index + 1, now.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else if (now.children[c - 'a'] != null) {
            return find(word, index + 1, now.children[c - 'a']);
        } else {
            return false;
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, 0, root);
    }
}


class TrieNode {
    public TrieNode[] children;
    public boolean hasWord;
    
    public TrieNode() {
        children = new TrieNode[26];
        for (int i = 0; i < 26; ++i)
            children[i] = null;
        hasWord = false;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 * 
 * 
 *
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
 */