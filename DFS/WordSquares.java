class WordSquares{ 
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Map<String, List<String>> prefixTable = createGraph(words);
        List<String> curr = new ArrayList<>();
        dfs(0, words[0].length(), prefixTable, curr, res);
        return res;
    }
    private Map<String, List<String>> createGraph(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            map.putIfAbsent("", new ArrayList<>());
            map.get("").add(word);
            String prefix = "";
            for (char c : word.toCharArray()) {
                prefix += c;
                map.putIfAbsent(prefix, new ArrayList<>());
                map.get(prefix).add(word);
            }
        }
        return map;
    }

    private void dfs(int nextRow, int wordLen, Map<String, List<String>> prefixTable, List<String> curr , List<List<String>> res) {
        if (nextRow == wordLen) {
            res.add(new ArrayList<>(curr));
            return;
        }

        String prefix = "";
        for (int i = 0; i < nextRow; i++) {
            prefix += curr.get(i).charAt(nextRow);
        }
        for (String next : prefixTable.get(prefix)) {
            curr.add(next);
            dfs(nextRow + 1, wordLen, prefixTable, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    private boolean checkPrefix(String next, int wordLen, int nextRow, Map<String, List<String>> prefixTable, List<String> curr) {
        for (int start = nextRow + 1; start < wordLen; start++) {
            String prefix = "";
            for (int i = 0; i < nextRow; i++) {
                prefix += curr.get(i).charAt(start);
            }
            prefix += next.charAt(start);
            if (!prefixTable.containsKey(prefix)) {
                return false;
            }
        }
        return true;
    }
}