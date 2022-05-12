package drivers;

import graph.BreadthFirstSearchIterative;
import graph.CloneGraph;
import graph.CourseSchedule;
import graph.CourseSchedule2;
import graph.DependencyResolution;
import graph.DepthFirstSearch;
import graph.DepthFirstSearchIterative;
import graph.NumberOfIslands;
import graph.TopologicalSort;
import graph.WordLadder;
import util.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphDriver {

    public void depthFirstSearch() {

        Node node = populateGraph();
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.performDFS(node);
    }

    public void depthFirstSearchAdjList() {

        List<List<Integer>> adjList = populateGraphAdjacencyList();
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.performDFSAdjList(adjList);
    }

    public void topologicalSort() {

        List<List<Integer>> adjList = populateAdjacencyListTopo();
        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.topologicalSort(adjList);
    }

    public void dependencyResolution() {

        List<List<Integer>> adjList = populateAdjacencyListDep();
        DependencyResolution dependencyResolution = new DependencyResolution();
        dependencyResolution.resolve(adjList);
    }

    public void depthFirstSearchIterative() {

        Node node = populateGraph();

        DepthFirstSearchIterative depthFirstSearchIterative = new DepthFirstSearchIterative();
        depthFirstSearchIterative.performDFS(node);
    }

    public void breadthFirstSearchIterative() {

        Node node = populateGraph();

        BreadthFirstSearchIterative breadthFirstSearchIterative = new BreadthFirstSearchIterative();
        breadthFirstSearchIterative.performBfs(node);
    }

    public void courseSchedule() {

        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println("canFinish=" + courseSchedule.canFinish(2, new int[][]{{1, 0}}));
        System.out.println("canFinish=" + courseSchedule.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    public void findOrder() {

        CourseSchedule2 courseSchedule = new CourseSchedule2();
//        courseSchedule.findOrder(2, new int[][]{{1, 0}});
        courseSchedule.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    }

    public void numberOfIslands() {

        char[][] grid = new char[][]
                {
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                };

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println("numIslands=" + numberOfIslands.numIslands(grid));
    }

    public void cloneGraph() {

        Node node = populateGraph();
        CloneGraph cloneGraph = new CloneGraph();
        cloneGraph.cloneGraph(node);
    }

    public void wordLadder() {

        List<String> wordList1 = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        List<String> wordList2 = new ArrayList<>(Arrays.asList("a", "b", "c"));

        WordLadder wordLadder = new WordLadder();
//        System.out.println("count=" + wordLadder.ladderLength("hit", "cog", wordList1));
        System.out.println("count=" + wordLadder.ladderLength("a", "c", wordList2));
    }

    ///////


    private Node populateGraph() {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node4);
        node3.neighbors.add(node7);
        node3.neighbors.add(node8);
        node4.neighbors.add(node5);
        node5.neighbors.add(node6);

        return node1;
    }

    private List<List<Integer>> populateGraphAdjacencyList() {

        List<List<Integer>> adjList = new ArrayList<>();

        adjList.add(0, Arrays.asList(1, 2));
        adjList.add(1, Arrays.asList(3));
        adjList.add(2, Arrays.asList(6, 7));
        adjList.add(3, Arrays.asList(4));
        adjList.add(4, Arrays.asList(5));
        adjList.add(5, Arrays.asList());
        adjList.add(6, Arrays.asList());
        adjList.add(7, Arrays.asList());

        return adjList;
    }

    private List<List<Integer>> populateAdjacencyListTopo() {

        List<List<Integer>> adjList = new ArrayList<>();

        adjList.add(0, Arrays.asList(1, 2));
        adjList.add(1, Arrays.asList(3));
        adjList.add(2, Arrays.asList(6, 7));
        adjList.add(3, Arrays.asList(4));
        adjList.add(4, Arrays.asList(5, 6));
        adjList.add(5, Arrays.asList());
        adjList.add(6, Arrays.asList());
        adjList.add(7, Arrays.asList());

        return adjList;
    }

    private List<List<Integer>> populateAdjacencyListDep() {

        List<List<Integer>> adjList = new ArrayList<>();

        adjList.add(0, Arrays.asList(1, 2));
        adjList.add(1, Arrays.asList(3));
        adjList.add(2, Arrays.asList(6, 7));
        adjList.add(3, Arrays.asList(4));
        adjList.add(4, Arrays.asList(5, 6));
        adjList.add(5, Arrays.asList());
        adjList.add(6, Arrays.asList(3));
        adjList.add(7, Arrays.asList());

        return adjList;
    }
}
