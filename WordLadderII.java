public class WordLadderII {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    
    Map<String, List<String>> graph = new HashMap<>();
    Map<String, Integer> lb = new HashMap<>();
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        dict.add(start);
        dict.add(end);
        for (String word : dict) {
            graph.put(word, getNext(word, dict));
            lb.put(word, getDiff(word,end));
        }
        
        int limit = 0;
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(start);
        while (res.isEmpty()) {
            dfs(limit, 1, start, end, path, res);
            limit++;
        }
        return res;
    }
    
    private List<String> getNext(String word, Set<String> dict) {
        List<String> ret = new ArrayList<>();
        
        for (int i = 0; i < word.length(); i++ ) {
            char[] wc = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                wc[i] = c;
                String next = String.valueOf(wc);
                if (!dict.contains(next) && !word.equals(next)) {
                    ret.add(next);
                }
            }
        }
        return ret;
    }
    
    private int getDiff(String a, String b) {
        int ret = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                ret++;
            }
        }
        return ret;
    }
    
    // 层数限制为limit, 即将要做的是第x层， 当前单词是word, 当前path是path, 
    private void dfs(int limit, int x, String word, String end, List<String> path, List<List<String>> res) {
        // 即将做第 limit + 1层表示： 第limit层已经做完了
        if (x == limit + 1) {
            if (word.equals(end)) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        // 剪枝： 即将要走第 x层， 意味着已经走了x - 1层， lb存放 word到 end 的对短变换次数， 
        // 如果已经走的步数 + 还剩的步数 > 当前limit的限制，那么就不用接着往下走了，此时需要增加limit
        if (x - 1 + lb.get(word) > limit) {
            return;
        }
        
        for (String next : graph.get(word)) {
            path.add(next);
            dfs(limit, x + 1, word, end, path, res);
            path.remove(path.size() - 1);
        }
        // 动态更新最少步数
        // 如果 res走到这里还为空，说明： 从word开始，走了 limit - (x - 1) 步还没走到end
        // 更新长度： (limit - (x - 1) + 1) 表示 再加一步才可能走到终点， 取max值
        if (res.isEmpty()) {
            lb.put(word, Math.max(limit - (x - 1) + 1, lb.get(word)));
        }
        
    }
}