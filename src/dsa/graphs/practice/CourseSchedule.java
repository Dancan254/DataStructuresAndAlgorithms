package dsa.graphs.practice;

/**
 * LeetCode 207 — Course Schedule
 * https://leetcode.com/problems/course-schedule/
 *
 * There are numCourses courses labeled 0 to numCourses-1.
 * prerequisites[i] = [a, b] means you must take course b before course a.
 * Return true if you can finish all courses (no cycle exists).
 *
 * Example 1:
 *   Input:  numCourses = 2, prerequisites = [[1,0]]
 *   Output: true   (take 0 then 1)
 *
 * Example 2:
 *   Input:  numCourses = 2, prerequisites = [[1,0],[0,1]]
 *   Output: false  (cycle: 0 requires 1, 1 requires 0)
 *
 * Constraints:
 *   - 1 <= numCourses <= 2000
 *   - 0 <= prerequisites.length <= 5000
 *
 * Hint: Model this as a directed graph. A valid schedule exists iff the graph
 *       has no cycle (it is a DAG).
 *       Use Kahn's algorithm (BFS topological sort):
 *         1. Compute in-degree for each node.
 *         2. Enqueue nodes with in-degree 0.
 *         3. Process each: reduce neighbours' in-degree; enqueue those reaching 0.
 *         4. If all nodes were processed, no cycle. If not, a cycle exists.
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();

        System.out.println(solution.canFinish(2, new int[][]{{1, 0}}));          // true
        System.out.println(solution.canFinish(2, new int[][]{{1,0},{0,1}}));     // false
        System.out.println(solution.canFinish(5, new int[][]{{1,0},{2,0},{3,1},{3,2}})); // true
    }
}
