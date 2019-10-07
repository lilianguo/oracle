/*
847. Shortest Path Visiting All Nodes

https://www.cnblogs.com/MrSaver/p/9465181.html
An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.

graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.

Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.

 

Example 1:

Input: [[1,2,3],[0],[0],[0]]
Output: 4
Explanation: One possible path is [1,0,2,0,3]
Example 2:

Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
Output: 4
Explanation: One possible path is [0,1,4,2,3]
 

Note:

1 <= graph.length <= 12
0 <= graph[i].length < graph.length
*/
class ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) { 
        // 二进制表达状态 最后的状态一定是 11111， 1的个数为顶点的个数
        int endingState = (1 << graph.length) - 1;

        // bfs 用queue记录下一步
        Queue<Pair> queue = new LinkedList<>();
        // visited[i][j] 记录顶点i 的状态j 是否访问过
        int[][] visited = new int[graph.length][1 << graph.length];

        // 求最短访问所有节点的路径意味着 起点没有specify，我们需要遍历所有节点为初始点的可能性
        for (int i = 0; i < graph.length; i++) {
            queue.offer(new Pair(i, 1<<i));
        }

        // 我们的图是没有weight的，两点之间间距都是1， 用step记录走了多少步
        int steps = 0;

        // 开始bfs
        while(!queue.isEmpty()) {
            // 层级遍历，像水滴一样一层层向外拓展，得到最短路径
            int s = queue.size();
            while(s-- > 0) {
                Pair pair = queue.poll();
                // n 表示当前的点， state表示当前点的状态
                int n = pair.i;
                int state = pair.j;

                // bfs出口： 第一个到达ending state 1111的点的步数就是答案
                if (state == endingState) {
                    return steps;
                }

                // 用visited数组来判断这个点的这个状态是不是已经访问过了，yes则跳过，否则是死循环
                if (visited[n][state] == 1) {
                    continue;
                }

                // 没有访问过的话可以现在标记为访问过，然后压入它的邻居点作为下一层
                visited[n][state] = 1;
                for (int next: graph[n]) {
                    queue.offer(new Pair(next, state | (1 << next)));
                }
            }
            // 一层结束， step + 1
            steps++;
        }
        // 没有找到状态达到endingstate的路径
        return -1;
    }

    class Pair {
        int i, j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}