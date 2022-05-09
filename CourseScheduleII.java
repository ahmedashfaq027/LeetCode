/*

https://leetcode.com/problems/course-schedule-ii/

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

Constraints:
1. 1 <= numCourses <= 2000
2. 0 <= prerequisites.length <= numCourses * (numCourses - 1)
3. prerequisites[i].length == 2
4. 0 <= ai, bi < numCourses
5. ai != bi
6. All the pairs [ai, bi] are distinct.

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
    Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
    Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
    So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Input: numCourses = 1, prerequisites = []
Output: [0]

*/

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        CourseScheduleII lc = new CourseScheduleII();

        System.out.println(Arrays.toString(lc.findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(lc.findOrder(2, new int[][]{{0, 1}, {1, 0}})));
        System.out.println(Arrays.toString(lc.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println(Arrays.toString(lc.findOrder(1, new int[][]{})));
    }

    /*
        Explanation:
            We used Topological sort (BFS). Topological sort works only with Directed, Acyclic graph.
            Hence, if cycle is detected, we return empty array. Topo array, otherwise.
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i : prerequisites) {
            adj.get(i[0]).add(i[1]);
        }

        int[] topo = new int[numCourses];
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

        int idx = numCourses - 1;
        int count = 0;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            topo[idx--] = tmp;
            count++;

            for (Integer i : adj.get(tmp)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }

        if (count == numCourses)
            return topo;

        return new int[0];
    }
}
