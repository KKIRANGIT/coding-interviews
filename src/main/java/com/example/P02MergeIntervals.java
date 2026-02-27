package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P02MergeIntervals {
    /*
     * Mindmap
     * MergeIntervals
     * - Inputs
     *   - intervals[][]
     * - Goal
     *   - merge overlapping intervals
     * - Strategy
     *   - sort by start
     *   - sweep, extend current if overlap
     * - Output
     *   - merged intervals
     * - Complexity
     *   - time: O(n log n)
     *   - space: O(n) for output
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter intervals (e.g. [[1,3],[2,6],[8,10]]):");
        String line = reader.readLine();
        int[][] intervals = parseIntervals(line);
        int[][] merged = merge(intervals);
        System.out.println(formatIntervals(merged));
    }

    static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0].clone();
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next.clone();
            }
        }
        merged.add(current);
        return merged.toArray(new int[0][]);
    }

    private static int[][] parseIntervals(String line) {
        int[] values = parseIntArray(line);
        int pairs = values.length / 2;
        int[][] intervals = new int[pairs][2];
        for (int i = 0; i < pairs; i++) {
            intervals[i][0] = values[i * 2];
            intervals[i][1] = values[i * 2 + 1];
        }
        return intervals;
    }

    private static int[] parseIntArray(String line) {
        if (line == null || line.trim().isEmpty()) {
            return new int[0];
        }
        String cleaned = line.replace("[", " ")
                             .replace("]", " ")
                             .replace(",", " ");
        String[] parts = cleaned.trim().split("\\s+");
        if (parts.length == 1 && parts[0].isEmpty()) {
            return new int[0];
        }
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        return nums;
    }

    private static String formatIntervals(int[][] intervals) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < intervals.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append("[").append(intervals[i][0]).append(", ").append(intervals[i][1]).append("]");
        }
        sb.append("]");
        return sb.toString();
    }
}

