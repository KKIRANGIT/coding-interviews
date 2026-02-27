# Coding Interviews - Java (LeetCode Problems)

This repository contains a minimal Java 17 project with standalone programs for common interview problems.
Each class has a short mindmap comment and a `main` method for quick runs.

## Problems Included (In Order)

1. Two Sum - P01TwoSum.java
2. Merge Intervals - P02MergeIntervals.java
3. Number of Islands - P03NumberOfIslands.java
4. Minimum Remove to Make Valid Parentheses - P04MinimumRemoveToMakeValidParentheses.java
5. Valid Palindrome II - P05ValidPalindromeII.java
6. Valid Parentheses - P06ValidParentheses.java
7. Subarray Sum Equals K - P07SubarraySumEqualsK.java
8. Longest Substring Without Repeating Characters - P08LongestSubstringWithoutRepeatingCharacters.java
9. Kth Largest Element in an Array - P09KthLargestElementInArray.java
10. Trapping Rain Water - P10TrappingRainWater.java

## Project Layout

- `src/main/java/com/example/*.java`

## Requirements

- Java 17
- Git
- A code editor or IDE of your choice

## Build and Run

Compile all:

```bash
javac -d out src/main/java/com/example/*.java
```

Run one class (example):

```bash
java -cp out com.example.P01TwoSum
```

## Input Format

Each program prints a short prompt. Arrays accept space or comma separated values, optional brackets.
Matrix/grid problems accept LeetCode-style formats like `[[1,1,0],[1,1,0],[0,0,1]]` or `["110","110","001"]`.
