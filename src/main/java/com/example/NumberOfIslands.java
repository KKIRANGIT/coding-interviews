package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NumberOfIslands {
    /*
     * Mindmap
     * NumberOfIslands
     * - Inputs
     *   - grid of '1' and '0'
     * - Goal
     *   - count connected components of land
     * - Strategy
     *   - scan grid
     *   - when find land, BFS/DFS to mark visited
     * - Output
     *   - island count
     * - Complexity
     *   - time: O(r*c)
     *   - space: O(r*c) worst-case
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter grid (e.g. [[1,1,0],[1,1,0],[0,0,1]] or [\"110\",\"110\",\"001\"]):");
        String line = reader.readLine();
        char[][] grid = parseGrid(line);
        int count = numIslands(grid);
        System.out.println(count);
    }

    static int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    islands++;
                    bfs(grid, visited, r, c);
                }
            }
        }
        return islands;
    }

    private static void bfs(char[][] grid, boolean[][] visited, int sr, int sc) {
        int rows = grid.length;
        int cols = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] { sr, sc });
        visited[sr][sc] = true;
        int[] dr = { 1, -1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };
        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    if (grid[nr][nc] == '1' && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.addLast(new int[] { nr, nc });
                    }
                }
            }
        }
    }

    private static char[][] parseGrid(String line) {
        if (line == null || line.trim().isEmpty()) {
            return new char[0][0];
        }
        String trimmed = line.trim();
        List<String> rows = new ArrayList<>();
        if (trimmed.contains("\"")) {
            StringBuilder current = new StringBuilder();
            boolean inQuotes = false;
            for (int i = 0; i < trimmed.length(); i++) {
                char ch = trimmed.charAt(i);
                if (ch == '"') {
                    if (inQuotes) {
                        rows.add(current.toString());
                        current.setLength(0);
                    }
                    inQuotes = !inQuotes;
                    continue;
                }
                if (inQuotes) {
                    current.append(ch);
                }
            }
        } else {
            if (trimmed.startsWith("[") && trimmed.endsWith("]")) {
                trimmed = trimmed.substring(1, trimmed.length() - 1);
            }
            String[] rowTokens = trimmed.split("\\]\\s*,\\s*\\[");
            for (String token : rowTokens) {
                String cleaned = token.replace("[", "")
                                      .replace("]", "")
                                      .replace(",", " ")
                                      .trim();
                if (cleaned.isEmpty()) {
                    continue;
                }
                String[] cells = cleaned.split("\\s+");
                StringBuilder row = new StringBuilder();
                for (String cell : cells) {
                    row.append(cell.charAt(0));
                }
                rows.add(row.toString());
            }
        }
        int r = rows.size();
        int c = r == 0 ? 0 : rows.get(0).length();
        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            String row = rows.get(i);
            for (int j = 0; j < c && j < row.length(); j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        return grid;
    }
}
