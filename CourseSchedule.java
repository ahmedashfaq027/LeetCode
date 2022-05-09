/*

https://leetcode.com/problems/course-schedule/

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Constraints:
1. 1 <= numCourses <= 2000
2. 0 <= prerequisites.length <= 5000
3. prerequisites[i].length == 2
4. 0 <= ai, bi < numCourses
5. All the pairs prerequisites[i] are unique.

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
    Explanation: There are a total of 2 courses to take.
    To take course 1 you should have finished course 0. So it is possible.

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
    Explanation: There are a total of 2 courses to take.
    To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule lc = new CourseSchedule();

        System.out.println(lc.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(lc.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    /*
        Explanation:
            We used Topological sort (BFS). Topological sort works only with Directed, Acyclic graph.
            Hence, if cycle is detected, we return false. True, otherwise.
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i : prerequisites) {
            adj.get(i[0]).add(i[1]);
        }

        int[] indegree = new int[numCourses];
        for (List<Integer> i : adj) {
            for (Integer j : i) {
                indegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            count++;

            for (Integer i : adj.get(tmp)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }

        if (count == numCourses)
            return true;

        return false;
    }

    /*
        Explanation:
            We used a DFS way to search the graph for cycles.
            vis[i] stores the overall visited nodes.
            dfsVis[i] stores the current path's visited nodes.
    */
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i : prerequisites) {
            adj.get(i[0]).add(i[1]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] dfsVis = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (checkCycle(i, adj, vis, dfsVis))
                    return false;
            }
        }

        return true;
    }

    private boolean checkCycle(int node, List<List<Integer>> adj, boolean[] vis, boolean[] dfsVis) {
        vis[node] = true;
        dfsVis[node] = true;

        for (Integer i : adj.get(node)) {
            if (!vis[i]) {
                if (checkCycle(i, adj, vis, dfsVis)) {
                    return true;
                }
            } else if (dfsVis[i]) {
                return true;
            }
        }

        dfsVis[node] = false;
        return false;
    }
}
