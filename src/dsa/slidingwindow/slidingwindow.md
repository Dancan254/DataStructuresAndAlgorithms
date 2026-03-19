What is sliding window?
 - the concept is maintaining a "window" (contiguous subarray/substring) that slides through the data structure, expanding and contracting based on conditions.
 - Why it works? Instead of recalculating everything for each subarray(O(n2)), we reuse previous calculations by adding/removing elements at the edges(O(N)).
```
Imagine looking through a window at a street:

Street: [🏠 🏢 🏪 🏫 ⛪ 🏥 🏦]
         [=====]              ← Your window (size 3)
         
Slide right:
Street: [🏠 🏢 🏪 🏫 ⛪ 🏥 🏦]
            [=====]           ← Remove left 🏠, add right 🏫
```

When to use it
- Finding **longest/shortest substring** with a condition
- **Maximum/minimum sum** of subarray of size K
- **Contiguous elements** that satisfy a criteria
- Problems with keywords: "substring", "subarray", "consecutive", "contiguous"
### ❌ NOT Sliding Window:
- Finding **subsequences** (can skip elements)
- Need to find **all combinations**
- Elements can be reordered
- Non-contiguous elements
### Quick Decision Tree:
```
Does the problem ask about...
├─ Substring/Subarray? → YES ✅
├─ Contiguous elements? → YES ✅
├─ Consecutive sequence? → YES ✅
├─ Can skip elements? → NO ❌
└─ Need all combinations? → NO ❌
```

Types of Sliding window
Fixed Size Window
- Window size is given of size k
Pattern:
- calculate the current window
- slide by removing leftmost, adding rightmost
- update result at each step

**Example:** "Find max sum of subarray of size 3"
```
Array: [2, 1, 5, 1, 3, 2]  k=3

Window 1: [2, 1, 5] → sum = 8
          ↓ slide
Window 2: [1, 5, 1] → sum = 7  (remove 2, add 1)
          ↓ slide  
Window 3: [5, 1, 3] → sum = 9  (remove 1, add 3)
          ↓ slide
Window 4: [1, 3, 2] → sum = 6  (remove 5, add 2)
```
### Type 2: Dynamic Size Window (Most Common!)
**Characteristic:** Window size changes based on condition
Pattern:
- Expand the window by moving the right pointer
- When condition is violated, shrink from left
- Track best result during valid windows
  **Example:** "Find the longest substring without repeating chars"
```
String: "abcabcbb"

Step 1: [a] → valid, expand
Step 2: [ab] → valid, expand
Step 3: [abc] → valid, expand ✨ len=3
Step 4: [abca] → INVALID! 'a' repeats
        Shrink: [bca] → valid
Step 5: [bcab] → INVALID! 'b' repeats
        Shrink: [cab] → valid