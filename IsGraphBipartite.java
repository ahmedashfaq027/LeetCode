/*

https://leetcode.com/problems/is-graph-bipartite/

There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

Constraints:
1. graph.length == n
2. 1 <= n <= 100
3. 0 <= graph[u].length < n
4. 0 <= graph[u][i] <= n - 1
5. graph[u] does not contain u.
6. All the values of graph[u] are unique.
7. If graph[u] contains v, then graph[v] contains u.

Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
    Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.

Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
    Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.

*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public static void main(String[] args) {
        IsGraphBipartite lc = new IsGraphBipartite();

        System.out.println(lc.isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
        System.out.println(lc.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
    }

    /*
        Explanation:
            Bipartite is about using only 2 colors. Hence we are using 0/1.
            We are using this color array as the visited array. if color[i] = -1, then unvisited.
            We traverse using BFS, if a node is visited/colored, we make sure it is not the same color as node.
    */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(graph, i, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean bfsCheck(int[][] adj, int node, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;

        while (!q.isEmpty()) {
            int tmp = q.poll();

            for (int i : adj[tmp]) {
                if (color[i] == -1) {
                    color[i] = 1 - color[tmp];
                    q.add(i);
                } else if (color[i] == color[tmp]) {
                    return false;
                }
            }
        }

        return true;
    }
}
