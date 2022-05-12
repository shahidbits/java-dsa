package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * LeetCode: https://leetcode.com/problems/course-schedule-ii/
 * NeetCode: https://www.youtube.com/watch?v=Akt3glAwyfY&list=PLot-Xpze53ldBT_7QA8NVot219jFNr_GI&index=3&ab_channel=NeetCode
 *
 */
public class CourseSchedule2 {

    private static int courseIdx;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses == 0) {
            return null;
        }

        if (numCourses == 1) {
            return new int[]{0};
        }

        if (prerequisites == null || prerequisites.length == 0) {
            return null;
        }

        List<List<Integer>> adjList = createAdjList(numCourses, prerequisites);

        Set<Integer> visited = new HashSet<>();
        Set<Integer> resolved = new HashSet<>();
        int[] courses = new int[numCourses];

        for (int i = 0; i < adjList.size(); i++) {

            if (!visited.contains(i)) {
                try {
                    dfsUtil(i, adjList, visited, resolved, courses);
                } catch (Exception ex) {
                    System.out.println("Exception :: " + ex.getMessage());
                    return null;
                }
            }
        }

        for (int c : courses) {
            System.out.println(c);
        }

        return courses;

    }

    private void dfsUtil(int vertex, List<List<Integer>> adjList, Set<Integer> visited, Set<Integer> resolved,
                         int[] courses) throws Exception {

        visited.add(vertex);

        List<Integer> edges = adjList.get(vertex);

        if (edges != null && edges.size() > 0) {

            for (Integer node : edges) {

                if (!resolved.contains(node)) {

                    if (visited.contains(node)) {

                        // circular dependency
                        throw new Exception("circular dep :: " + vertex + " <--> " + node);

                    }

                    dfsUtil(node, adjList, visited, resolved, courses);

                }
            }
        }

        courses[courseIdx++] = vertex;
        resolved.add(vertex);

    }

    private List<List<Integer>> createAdjList(int count, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            adjList.add(new ArrayList<>());
        }

        if (edges != null && edges.length > 0) {

            for (int[] e : edges) {
                adjList.get(e[0]).add(e[1]);
            }

        }

        return adjList;
    }
}
