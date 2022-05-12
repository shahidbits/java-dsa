package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * LeetCode: https://leetcode.com/problems/word-ladder/
 * NeetCode: https://www.youtube.com/watch?v=h9iTnkgv05E&list=PLot-Xpze53ldBT_7QA8NVot219jFNr_GI&index=7&ab_channel=NeetCode
 *
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (wordList == null || wordList.size() == 0) {
            return 0;
        }

        if (wordList.size() == 1 && !wordList.get(0).equals(endWord)) {
            return 0;
        }

        wordList.add(beginWord);

        Map<String, List<String>> adjList = createAdjList(wordList);
        Set<String> visited = new HashSet<>();

        return bfs(beginWord, endWord, adjList.size() - 1, adjList, visited);

    }

    private int bfs(String beginWord, String endWord, int idx, Map<String, List<String>> adjList, Set<String> visited) {

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 1;

        while (!queue.isEmpty()) {

            int len = queue.size();

            for (int i = 0; i < len; i++) {

                String node = queue.remove();
                visited.add(node);

                if (endWord.equals(node)) {
                    return count;
                }

                List<String> neighbors = adjList.get(node);

                if (neighbors != null && neighbors.size() > 0) {

                    for (String n : neighbors) {
                        if (!visited.contains(n)) {
                            queue.add(n);
                        }
                    }

                }
            }

            count++;
        }

        return 0;

    }

    private Map<String, List<String>> createAdjList(List<String> wordList) {

        Map<String, List<String>> adjList = new HashMap<>();

        if (wordList != null && wordList.size() > 0) {

            for (int i = 0; i < wordList.size(); i++) {

                adjList.put(wordList.get(i), new ArrayList<>());

                for (int j = 0; j < wordList.size(); j++) {

                    if (i != j && diffInChars(wordList.get(i), wordList.get(j)) == 1) {
                        adjList.get(wordList.get(i)).add(wordList.get(j));
                    }

                }
            }

        }

        return adjList;
    }

    private int diffInChars(String s1, String s2) {

        int c = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                c++;
            }
        }

        return c;

    }
}
