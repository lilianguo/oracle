import java.util.List;

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