package dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 207 — Course Schedule
 *
 * Determine if you can finish all courses given prerequisite pairs.
 * A cycle in the dependency graph makes it impossible.
 *
 * Pattern: Topological sort — Kahn's Algorithm (BFS)
 *
 * 1. Build adjacency list and in-degree array.
 * 2. Enqueue all nodes with in-degree 0 (no prerequisites).
 * 3. Process each: decrement neighbours' in-degree; enqueue those reaching 0.
 * 4. If all courses processed, the graph is acyclic — return true.
 *
 * Time:  O(V + E)
 * Space: O(V + E)
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            // pre[1] must be taken before pre[0]
            adj.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int processed = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            processed++;
            for (int next : adj.get(course)) {
                if (--inDegree[next] == 0) queue.offer(next);
            }
        }

        // If processed < numCourses, a cycle was detected
        return processed == numCourses;
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();

        System.out.println(solution.canFinish(2, new int[][]{{1, 0}}));         // true
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}})); // false (cycle)
    }
}
