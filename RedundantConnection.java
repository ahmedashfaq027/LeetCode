/*

https://leetcode.com/problems/redundant-connection/

In this problem, a tree is an undirected graph that is connected and has no cycles.
You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

Constraints:
1. n == edges.length
2. 3 <= n <= 1000
3. edges[i].length == 2
4. 1 <= ai < bi <= edges.length
5. ai != bi
6. There are no repeated edges.
7. The given graph is connected.

Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]

Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]

*/

import java.util.Arrays;

public class RedundantConnection {
    int[] parent;
    int[] rank;

    public static void main(String[] args) {
        RedundantConnection lc = new RedundantConnection();

        System.out.println(Arrays.toString(lc.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
        System.out.println(Arrays.toString(lc.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));
    }

    /*
        Explanation:
            We have applied Union find method in here (with compression - memoize the parent)
            Union find is used to determine connected components in graph.
            Union find is also used to determine if cycle can be formed by adding 2 edges.
    */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] i : edges) {
            if (!union(i[0], i[1]))
                return i;
        }

        return new int[0];
    }

    private boolean union(int u, int v) {
        u = findParent(u);
        v = findParent(v);

        if (u != v) {
            if (rank[u] < rank[v]) {
                parent[u] = v;
            } else if (rank[v] < rank[u]) {
                parent[v] = u;
            } else {
                parent[v] = u;
                rank[u]++;
            }
            return true;
        } else {
            return false;
        }
    }

    private int findParent(int n) {
        if (parent[n] == n)
            return n;

        return parent[n] = findParent(parent[n]);
    }
}
