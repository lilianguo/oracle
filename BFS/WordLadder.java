/*
import java.util.Queue;
import java.util.Set;
127. Word Ladder

Given two words (beginWord and endWord), and a dictionary's word list, 
find the length of shortest transformation sequence from beginWord to endWord, such that:

1. Only one letter can be changed at a time.
2. Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/
class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() < 1) {
            return 0;
        }
        Set<String> words = new HashSet<>();
        for (String word : wordList) {
            words.add(word);
        }
        if (!words.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int len = 1;
        while(!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                System.out.println("curr is :" + curr);
                for (String next : getNext(curr, words, visited)) {
                    if (next.equals(endWord)) {
                        return len;
                    }
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
        return 0;
    }
    private List<String> getNext(String curr, Set<String> words, Set<String> visited) {
        List<String> nexts = new ArrayList<>();
        for (int i = 0; i < curr.length(); i++) {
            char[] cs = curr.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == cs[i]) {
                    continue;
                }
                cs[i] = c;
                String replaced = String.valueOf(cs);
                //System.out.println("replaced is  " + replaced);
                if (words.contains(replaced) && !visited.contains(replaced)) {
                    System.out.println("replaced is  " + replaced);
                    nexts.add(replaced);
                }
            }
        }
        System.out.println(nexts.size());
        return nexts;
    }
}