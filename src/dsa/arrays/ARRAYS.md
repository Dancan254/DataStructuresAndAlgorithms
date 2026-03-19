# Arrays — Data Structures & Algorithms

## What is an Array?

An **array** is a data structure that stores elements of the **same data type** in **contiguous memory locations**.

Each element is accessed via an **index** (zero-based in Java):

```
Index:  [0]  [1]  [2]  [3]  [4]
Value:   10   20   30   40   50
```

---

## Key Characteristics

| Property        | Detail                                      |
|-----------------|---------------------------------------------|
| Size            | Fixed at creation time                      |
| Access          | O(1) — direct via index                     |
| Search (unsorted)| O(n) — linear scan                        |
| Search (sorted) | O(log n) — binary search                   |
| Insert/Delete   | O(n) — elements must shift                 |
| Memory          | Contiguous block                            |

---

## Declaring Arrays in Java

```java
// Declaration and initialization
int[] numbers = {1, 2, 3, 4, 5};

// Declaration with size
int[] scores = new int[10];

// Access element
System.out.println(numbers[0]); // 10

// Array length
System.out.println(numbers.length); // 5
```

---

## Common Operations

### Traversal — O(n)
```java
for (int i = 0; i < array.length; i++) {
    System.out.println(array[i]);
}
```

### Reverse — O(n)
Use two pointers: one at the start, one at the end, swap until they meet.
```java
int start = 0, end = array.length - 1;
while (start < end) {
    int temp = array[start];
    array[start] = array[end];
    array[end] = temp;
    start++;
    end--;
}
```

### Find Max/Min — O(n)
```java
int max = array[0];
for (int num : array) {
    if (num > max) max = num;
}
```

### Linear Search — O(n)
```java
for (int i = 0; i < array.length; i++) {
    if (array[i] == target) return i;
}
return -1;
```

### Binary Search — O(log n) *(array must be sorted)*
```java
int left = 0, right = array.length - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (array[mid] == target) return mid;
    else if (array[mid] < target) left = mid + 1;
    else right = mid - 1;
}
return -1;
```

---

## Two-Pointer Technique

A powerful pattern for array problems — use two indices moving toward each other or in the same direction.

**Use cases:** reversing, checking palindromes, finding pairs with target sum.

```java
int left = 0, right = array.length - 1;
while (left < right) {
    // process array[left] and array[right]
    left++;
    right--;
}
```

---

## Sliding Window Technique

Used for problems involving **subarrays** of a fixed or variable size.

```java
int windowSum = 0;
int k = 3; // window size
for (int i = 0; i < k; i++) windowSum += array[i];

int maxSum = windowSum;
for (int i = k; i < array.length; i++) {
    windowSum += array[i] - array[i - k];
    maxSum = Math.max(maxSum, windowSum);
}
```

---

## Time & Space Complexity Summary

| Operation      | Time   | Space  |
|----------------|--------|--------|
| Access by index| O(1)   | O(1)   |
| Linear Search  | O(n)   | O(1)   |
| Binary Search  | O(log n)| O(1)  |
| Insert at end  | O(1)*  | O(1)   |
| Insert at index| O(n)   | O(1)   |
| Delete         | O(n)   | O(1)   |
| Reverse        | O(n)   | O(1)   |

*Amortized for dynamic arrays (e.g., ArrayList)

---

## Practice Questions

---

### Q1 — Reverse an Array
**Difficulty:** Easy

Given an integer array, reverse it **in-place** (without using a second array).

**Example:**
```
Input:  [1, 2, 3, 4, 5, 6]
Output: [6, 5, 4, 3, 2, 1]
```

**Hint:** Use the two-pointer approach with a `start` and `end` index.

---

### Q2 — Find the Missing Number
**Difficulty:** Easy

Given an array of `n` distinct integers in the range `[1, n+1]`, find the one missing number.

**Example:**
```
Input:  [1, 2, 4, 5]
Output: 3
```

**Hint:** The sum of `1` to `n+1` is `(n+1)(n+2)/2`. Subtract the array sum.

---

### Q3 — Move Zeros to the End
**Difficulty:** Easy

Given an array of integers, move all `0`s to the end while maintaining the relative order of the non-zero elements. Do this **in-place**.

**Example:**
```
Input:  [0, 1, 0, 3, 12]
Output: [1, 3, 12, 0, 0]
```

**Hint:** Use a pointer to track the position of the next non-zero element.

---

### Q4 — Contains Duplicate
**Difficulty:** Easy

Given an integer array, return `true` if any value appears **more than once**, otherwise return `false`.

**Example:**
```
Input:  [1, 2, 3, 1]
Output: true

Input:  [1, 2, 3, 4]
Output: false
```

**Hint:** Use a `HashSet` to track seen values.

---

### Q5 — Second Maximum Element
**Difficulty:** Medium

Find the second largest element in an array **without sorting it**.

**Example:**
```
Input:  [10, 5, 8, 20, 15]
Output: 15
```

**Hint:** Track both `max` and `secondMax` in a single pass.

---

### Q6 — Target Sum (Two Sum)
**Difficulty:** Medium

Given an array of integers and a target value, return the **indices** of the two numbers that add up to the target.

**Example:**
```
Input:  [2, 7, 11, 15], target = 9
Output: [0, 1]  (because 2 + 7 = 9)
```

**Hint:** Use a `HashMap` to store `value -> index` as you iterate. Check if `target - current` is already in the map.

---

### Q7 — Longest Prefix which is also Suffix
**Difficulty:** Medium/Hard

Given a string, find the length of the longest **prefix** that is also a **suffix** (but not the string itself).

**Example:**
```
Input:  "abcab"
Output: 2  (prefix "ab" == suffix "ab")

Input:  "aaaa"
Output: 3
```

**Hint:** This is the KMP failure function. Compare characters from both ends.

---

### Q8 — Best Time to Buy and Sell Stock
**Difficulty:** Medium

Given an array where `prices[i]` is the price of a stock on day `i`, find the **maximum profit** you can achieve from one buy and one sell (you must buy before you sell).

**Example:**
```
Input:  [7, 1, 5, 3, 6, 4]
Output: 5  (buy at 1, sell at 6)
```

**Hint:** Track `minPrice` seen so far, and at each step compute `price - minPrice`.

---

## Solutions Reference

All solutions are implemented in `src/dsa/arrays/practice/`. Try to solve each problem on your own before looking at the code!

| Question                          | File                          |
|-----------------------------------|-------------------------------|
| Reverse an Array                  | `ReverseArray.java`           |
| Find the Missing Number           | `MissingNumber.java`          |
| Move Zeros to the End             | `MovingZerosToEnd.java`       |
| Contains Duplicate                | `ContainsDuplicate.java`      |
| Second Maximum Element            | `SecondMaximumElement.java`   |
| Target Sum (Two Sum)              | `TargetSum.java`              |
| Longest Prefix which is Suffix    | `LongestPrefixSuffix.java`    |
| Best Time to Buy and Sell Stock   | `BuySellStocks.java`          |
