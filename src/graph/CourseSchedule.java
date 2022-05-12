package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * LeetCode: https://leetcode.com/problems/course-schedule/
 * NeetCode: https://www.youtube.com/watch?v=EgI5nU9etnU&list=PLot-Xpze53ldBT_7QA8NVot219jFNr_GI&index=2&ab_channel=NeetCode
 *
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        List<List<Integer>> adjList = createAdjList(numCourses, prerequisites);

        Set<Integer> visited = new HashSet<>();
        Set<Integer> resolved = new HashSet<>();

        for (int i = 0; i < adjList.size(); i++) {

            if (!visited.contains(i)) {
                try {
                    dfsUtil(i, adjList, visited, resolved);
                } catch (Exception ex) {
                    System.out.println("Exception :: " + ex.getMessage());
                    return false;
                }
            }
        }

        if (resolved.size() == numCourses) {
            return true;
        }

        return false;

    }

    private void dfsUtil(int vertex, List<List<Integer>> adjList, Set<Integer> visited, Set<Integer> resolved) throws Exception {

        visited.add(vertex);

        List<Integer> edges = adjList.get(vertex);

        if (edges != null && edges.size() > 0) {

            for (Integer node : edges) {

                if (!resolved.contains(node)) {

                    if (visited.contains(node)) {

                        // circular dependency
                        throw new Exception("circular dep :: " + vertex + " <--> " + node);

                    }

                    dfsUtil(node, adjList, visited, resolved);

                }
            }
        }

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
