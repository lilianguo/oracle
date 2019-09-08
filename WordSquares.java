class WordSquares{
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Map<String,List<String>> prefixTable = new HashMap<>();
        createPrefixTable(words, prefixTable);
        List<String> curr = new ArrayList<>();
        dfs(0, words[0].length(), prefixTable, curr, res);
        return res;
    }
    
    /**
     * 构造prefix table
     * @param words 词库
     * @param prefixTable 最终返回的table
     */
    private void createPrefixTable(String[] words, Map<String,List<String>> prefixTable) {
        for (String word : words) {
            prefixTable.putIfAbsent("", new ArrayList<>());
            prefixTable.get("").add(word);
            String prefix = "";
            for (char c : word.toCharArray()) {
                prefix += c;
                prefixTable.putIfAbsent(prefix, new ArrayList<>());
                prefixTable.get(prefix).add(word);
            }
        }
    }
  
    /**
     * nextRow: 下一个要填的行数
     * wordLen: 单词的长度
     * prefixTable: 所有前缀的树
     * curr： 当前的结果，是一个list of string
     * res: 最终的返回结果，是List<List<String>>
     */
    private void dfs(int nextRow, int wordLen, Map<String,List<String>> prefixTable, List<String> curr, List<List<String>> res) {
        if (nextRow == wordLen) {
            res.add(new ArrayList<>(curr));
            return;
        }
        String prefix = "";
        for (int i = 0; i < nextRow; i++) {
            prefix += curr.get(i).charAt(nextRow);
        }
        
        for (String next : prefixTable.get(prefix)) {
            if (!checkPrefix(next, nextRow, wordLen, prefixTable, curr)) {
                continue;
            }
            curr.add(next);
            dfs(nextRow + 1, wordLen, prefixTable, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
    
    /**
     * 比如： 第一行填 ball
     *       第二行想填 area （即next）
     *       后面几行 必须有以 le la 为prefix的单词在table中才可行
     * @param next 下一个要填的单词
     * @param nextRow next 会填到的行数
     * @param wordLen 单词的长度
     * @param prefixTable prefix table
     * @param curr 当前的结果，包含已经填进去的单词
     * @return next到底能不能填完之后保证后面还能继续填
     */
    private boolean checkPrefix(String next, int nextRow, int wordLen, Map<String,List<String>> prefixTable, List<String> curr) {
        for (int start = nextRow + 1; start < wordLen; start++) {
            String prefix = "";
            for (int k = 0; k < nextRow; k++) {
                prefix += curr.get(k).charAt(start);
            }
            prefix += next.charAt(start);
            if (!prefixTable.containsKey(prefix)) {
                return false;
            }
        }
        return true;
    }
}