# Stack — Exercises

---

## Easy

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 1 | Valid Parentheses | [20](https://leetcode.com/problems/valid-parentheses/) | Yes | Push openers, match closers |
| 2 | Baseball Game | [682](https://leetcode.com/problems/baseball-game/) | No | Simulate with a stack |

## Medium

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 3 | Min Stack | [155](https://leetcode.com/problems/min-stack/) | No | Parallel min-tracking stack |
| 4 | Evaluate Reverse Polish Notation | [150](https://leetcode.com/problems/evaluate-reverse-polish-notation/) | No | Operand stack, apply on operator |
| 5 | Generate Parentheses | [22](https://leetcode.com/problems/generate-parentheses/) | No | Backtracking — open/close count constraints |
| 6 | Daily Temperatures | [739](https://leetcode.com/problems/daily-temperatures/) | No | Monotonic decreasing stack of indices |
| 7 | Car Fleet | [853](https://leetcode.com/problems/car-fleet/) | No | Sort by position, stack of arrival times |

## Hard

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 8 | Largest Rectangle in Histogram | [84](https://leetcode.com/problems/largest-rectangle-in-histogram/) | No | Monotonic increasing stack, expand left |

---

## Reflection Questions

1. Why is `ArrayDeque` preferred over `Stack<T>` in Java?
2. In a monotonic stack, what invariant do you maintain — and what does violating it mean?
3. In Min Stack, why must the min-stack be updated on every push, not only when a new minimum is found?
