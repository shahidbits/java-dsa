package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * LeetCode: https://leetcode.com/problems/number-of-islands/
 * NeetCode: https://www.youtube.com/watch?v=pV2kpPD66nE&list=PLot-Xpze53ldBT_7QA8NVot219jFNr_GI&index=5&ab_channel=NeetCode
 *
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        if (grid == null) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1' && visited[i][j] == false) {
                    dfs(i, j, grid, visited);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {

        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length &&
                visited[i][j] == false &&
                grid[i][j] == '1') {

            visited[i][j] = true;

            dfs(i + 1, j, grid, visited);
            dfs(i - 1, j, grid, visited);
            dfs(i, j + 1, grid, visited);
            dfs(i, j - 1, grid, visited);

        }

    }

    public int numIslands2(char[][] grid) {

        if (grid == null) {
            return 0;
        }

        Set<String> visited = new HashSet<>();

        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1') {

                    Cell cell = new Cell(i, j);

                    if (!visited.contains(cell.toString())) {
                        bfs(cell, grid, visited);
                        islands++;
                    }
                }
            }
        }

        return islands;
    }

    private void bfs(Cell cell, char[][] grid, Set<String> visited) {

        Queue<Cell> queue = new LinkedList<>();
        queue.add(cell);

        while (!queue.isEmpty()) {

            Cell rootCell = queue.remove();
            visited.add(rootCell.toString());

            Cell cellLeft = new Cell(rootCell.x, rootCell.y - 1);
            Cell cellTop = new Cell(rootCell.x - 1, rootCell.y);
            Cell cellRight = new Cell(rootCell.x, rootCell.y + 1);
            Cell cellBottom = new Cell(rootCell.x + 1, rootCell.y);

            if (!visited.contains(cellLeft.toString()) &&
                    isBounded(grid.length, grid[rootCell.x].length, cellLeft) &&
                    grid[cellLeft.x][cellLeft.y] == '1') {
                queue.add(cellLeft);
                visited.add(cellLeft.toString());
            }

            if (!visited.contains(cellTop.toString()) &&
                    isBounded(grid.length, grid[rootCell.x].length, cellTop) &&
                    grid[cellTop.x][cellTop.y] == '1') {
                queue.add(cellTop);
                visited.add(cellTop.toString());
            }

            if (!visited.contains(cellRight.toString()) &&
                    isBounded(grid.length, grid[rootCell.x].length, cellRight) &&
                    grid[cellRight.x][cellRight.y] == '1') {
                queue.add(cellRight);
                visited.add(cellRight.toString());
            }

            if (!visited.contains(cellBottom.toString()) &&
                    isBounded(grid.length, grid[rootCell.x].length, cellBottom) &&
                    grid[cellBottom.x][cellBottom.y] == '1') {
                queue.add(cellBottom);
                visited.add(cellBottom.toString());
            }

        }

    }

    private boolean isBounded(int rowCount, int colCount, Cell cell) {

        if (cell.x >= 0 && cell.x < rowCount && cell.y >= 0 && cell.y < colCount) {
            return true;
        }

        return false;

    }

    private class Cell {

        public int x;
        public int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x * 31 + y;
        }

        @Override
        public String toString() {
            return String.format("x=%s y=%s", x, y);
        }

    }
}
