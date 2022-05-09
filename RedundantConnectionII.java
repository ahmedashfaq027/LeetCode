/*

https://leetcode.com/problems/redundant-connection-ii/

In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
The given input is a directed graph that started as a rooted tree with n nodes (with distinct values from 1 to n), with one additional directed edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [ui, vi] that represents a directed edge connecting nodes ui and vi, where ui is a parent of child vi.

Return an edge that can be removed so that the resulting graph is a rooted tree of n nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

Constraints:
1. n == edges.length
2. 3 <= n <= 1000
3. edges[i].length == 2
4. 1 <= ui, vi <= n
5. ui != vi

Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]

Input: edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
Output: [4,1]

*/

import java.util.Arrays;

public class RedundantConnectionII {
    int[] parent;
    int[] rank;

    public static void main(String[] args) {
        RedundantConnectionII lc = new RedundantConnectionII();

        System.out.println(Arrays.toString(lc.findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
        System.out.println(Arrays.toString(lc.findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}})));
        System.out.println(Arrays.toString(lc.findRedundantDirectedConnection(new int[][]{{2, 1}, {3, 1}, {4, 2}, {1, 4}})));
        System.out.println(Arrays.toString(lc.findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 1}, {4, 1}})));
    }

    /*
        Explanation:
            We have applied Union find method in here (with compression - memoize the parent)
            Union find is used to determine connected components in graph.
            Union find is also used to determine if cycle can be formed by adding 2 edges.

            case-1: We simply find the edge that is causing indegree[v] > 1 and remove it
            case-2: If there are no nodes with more than 1 parent, but graph contains cycle. we do a union find and return the cyclic causing edge.
            case-3: Combination of both case-1 and case-2. We ignore the case-1 edge and do union find. If we do still find cycle, then we removed wrong edge.
            Hence, we remove blacklist2. (Previous edge with indegree[v] > 1)
    */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];
        int[] indegree = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
            rank[i] = -1;
            indegree[i] = -1;
        }

        int blackList1 = -1, blackList2 = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[edges[i][1]] != -1) {
                blackList1 = i;
                blackList2 = indegree[edges[i][1]];
            }

            indegree[edges[i][1]] = i;
        }

        boolean hasCycle = false;
        for (int i = 0; i < n; i++) {
            if (i == blackList1)
                continue;

            if (!union(edges[i][0], edges[i][1])) {
                if (blackList1 == -1)
                    return edges[i];

                hasCycle = true;
                break;
            }
        }

        if (!hasCycle)
            return edges[blackList1];
        else
            return edges[blackList2];
    }

    private boolean union(int u, int v) {
        u = findParent(u);
        v = findParent(v);

        if (u != v) {
            parent[u] = v;
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
