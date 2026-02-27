package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P07SubarraySumEqualsK {
    /*
     * Mindmap
     * SubarraySumEqualsK
     * - Inputs
     *   - nums[]
     *   - k
     * - Goal
     *   - count subarrays that sum to k
     * - Strategy
     *   - prefix sum
     *   - count of previous sums
     * - Output
     *   - count
     * - Complexity
     *   - time: O(n)
     *   - space: O(n)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter numbers (space or comma separated, optional brackets):");
        String numbersLine = reader.readLine();
        System.out.println("Enter k:");
        String kLine = reader.readLine();
        int[] nums = parseIntArray(numbersLine);
        int k = Integer.parseInt(kLine.trim());
        System.out.println(subarraySum(nums, k));
    }

    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int prefix = 0;
        int total = 0;
        for (int num : nums) {
            prefix += num;
            total += counts.getOrDefault(prefix - k, 0);
            counts.put(prefix, counts.getOrDefault(prefix, 0) + 1);
        }
        return total;
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
}

