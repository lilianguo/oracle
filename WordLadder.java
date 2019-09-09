import java.util.List;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() < 1) {
            return 0;
        }
        Set<String> words = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            words.add(wordList.get(i));
        }
        List<String> ladder = new ArrayList<>();
        ladder.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        return bfs(beginWord, endWord, ladder, visited, words);
    }

    private int bfs(String beginWord, String endWord, List<String> ladder, Set<String> visited, Set<String> words) {
        if (ladder.get(ladder.size() - 1).equals(endWord)) {
            return ladder.size();
        }

        String curr = ladder.get(ladder.size() - 1);
        for (String next : getNext(curr, words, visited)) {
            ladder.add(next);
            visited.add(next);
            bfs(beginWord, endWord, ladder, visited, words);
            ladder.remove(ladder.size() - 1);
            visited.remove(next);
        }
    }

    private List<String> getNext(String curr, Set<String> words, Set<String> visited) {
        List<String> nexts = new ArrayList<>();
        char[] cs = curr.toCharArray();
        for (int i = 0; i < curr.length(); i++) {
            for (char c = 'a'; c < 'z'; c++) {
                if (c != curr.charAt(i)) {
                    cs[i] = c;
                    if (!visited.get(cs.toString())) {
                        words.add(cs.toString());
                    }
                }
            }
        }
        return words;
    }


    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }
        
        dict.add(start);
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        Set<String> hash = new HashSet<>();
        int res = 1;
        queue.offer(start);
        hash.add(start);
        while(!queue.isEmpty()) {        	//开始bfs
            res++;
            int size = queue.size();		//当前步数的队列大小
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord: getNext(word, dict)) {	//得到新单词
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return res;
                    }
                    
                    hash.add(nextWord);
                    queue.offer(nextWord);			//存入队列继续搜索
                }
            }
        }
        return 0;
    }
    

    
     List<String> getNext(String s, Set<String> dict) {
        List<String> ret = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            char[] sc = s.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                sc[i] = c;
                String curr = String.valueOf(sc);
                if (dict.contains(curr) && !curr.equals(s)) {
                    ret.add(curr);
                }
            }
        }
        return ret;
    }
}