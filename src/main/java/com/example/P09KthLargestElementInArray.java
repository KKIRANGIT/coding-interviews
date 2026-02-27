package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class P09KthLargestElementInArray {
    /*
     * Mindmap
     * KthLargestElementInArray
     * - Inputs
     *   - nums[]
     *   - k
     * - Goal
     *   - find k-th largest element
     * - Strategy
     *   - quickselect with random pivot
     *   - partition by descending order
     * - Output
     *   - value
     * - Complexity
     *   - average time: O(n)
     *   - space: O(1)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter numbers (space or comma separated, optional brackets):");
        String numbersLine = reader.readLine();
        System.out.println("Enter k:");
        String kLine = reader.readLine();
        int[] nums = parseIntArray(numbersLine);
        int k = Integer.parseInt(kLine.trim());
        System.out.println(findKthLargest(nums, k));
    }

    static int findKthLargest(int[] nums, int k) {
        int target = k - 1;
        int left = 0;
        int right = nums.length - 1;
        Random random = new Random();
        while (left <= right) {
            int pivotIndex = left + random.nextInt(right - left + 1);
            int newIndex = partitionDesc(nums, left, right, pivotIndex);
            if (newIndex == target) {
                return nums[newIndex];
            } else if (newIndex < target) {
                left = newIndex + 1;
            } else {
                right = newIndex - 1;
            }
        }
        return -1;
    }

    private static int partitionDesc(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int store = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > pivotValue) {
                swap(nums, store, i);
                store++;
            }
        }
        swap(nums, store, right);
        return store;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
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

