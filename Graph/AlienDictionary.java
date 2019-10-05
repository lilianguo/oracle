import java.util.Queue;

/*
269. Alien Dictionary
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. 
You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
] 

Output: "" 

Explanation: The order is invalid, so return "".
Note:

You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
*/
class AlienDictionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        Map<Character, Set<Character>> graph = createGraph(words);
        return topologicSort(graph);
    }

    private String topologicSort(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = getIndegree(graph);
        Queue<Character> queue = new LinkedList<>();
        for (Character key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            Character head = queue.poll();
            sb.append(head);
            for (Character neightbor : graph.get(head)) {
                indegree.put(neightbor, indegree.get(neightbor) - 1);
                if (indegree.get(neightbor) == 0){
                    queue.add(neightbor);
                }
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
    private Map<Character, Set<Character>> createGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (Character c : words[i].toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String prev = words[i  - 1];
            String curr = words[i];
            for (int j = 0; j < Math.min(prev.length(), curr.length()); j++) {
                if (prev.charAt(j) != curr.charAt(j)) {
                    graph.get(prev.charAt(j)).add(curr.charAt(j));
                    break;
                }
            }
        }
        return graph;
    }
    private Map<Character, Integer> getIndegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();
        for (Character c : graph.keySet()) {
            indegree.put(c, 0);
        }   
        for (Character key : graph.keySet()) {
            for (Character next : graph.get(key)) {
                indegree.put(next, indegree.get(next) + 1);
            }
        }
        return indegree;
    }
}