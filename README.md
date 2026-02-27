# Coding Interviews - Java (LeetCode Problems)

This repository contains a minimal Java 17 project with standalone programs for common interview problems.
Each class has a short mindmap comment and a `main` method for quick runs.

## Problems Included

- Two Sum
- Merge Intervals
- Number of Islands
- Minimum Remove to Make Valid Parentheses
- Valid Palindrome II
- Valid Parentheses
- Subarray Sum Equals K
- Longest Substring Without Repeating Characters
- Kth Largest Element in an Array
- Trapping Rain Water

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
java -cp out com.example.TwoSum
```

## Input Format

Each program prints a short prompt. Arrays accept space or comma separated values, optional brackets.
Matrix/grid problems accept LeetCode-style formats like `[[1,1,0],[1,1,0],[0,0,1]]` or `["110","110","001"]`.
