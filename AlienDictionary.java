import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.sun.java.util.jar.pack.ConstantPool.IndexGroup;

class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = createGraph(words);
        return topologicalSort(graph);
    }

    private Map<Character, Set<Character>> createGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                graph.putIfAbsent(words[i].charAt(j), new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            int len = Math.min(words[i - 1].length(), words[i].length());
            String pre = words[i - 1];
            String curr = words[i];
            for (int j = 0; j < len; j++) {
                if (pre.charAt(j) != curr.charAt(j)) {
                    graph.get(pre.charAt(j)).add(curr.charAt(j));
                    break;
                }
            }
        }
        return graph;
    }

    private String topologicalSort(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = getIndegree(graph);
        PriorityQueue<Character> queue = new PriorityQueue<>();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                System.out.println("head: " + c);
                queue.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            Character head = queue.poll();
            sb.append(head);
            //System.out.println(sb.toString());
            for(Character next : graph.get(head)) {
                indegree.put(next, indegree.get(next)  - 1);
                if (indegree.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }

    private Map<Character, Integer> getIndegree (Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();
        for (Character c : graph.keySet()) {
            indegree.put(c, 0);
        }

        for (Character key : graph.keySet()) {
            for (Character c : graph.get(key)) {
                indegree.put(c, indegree.get(c) + 1);
            }
        }

        return indegree;
    }
}