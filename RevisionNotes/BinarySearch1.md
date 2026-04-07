
The whole idea of binary search is to reduce the search space by half in each iteration.

### Sample Problem(But outcome is important)

Given a sorted array, find the number of negative elements in it.

Now, this is far from what we have learnt. We have no particular value to look for. No target. So, how to go about it?

```swift
Let's say that the arrayisIndex012345678910nums=[-101,-99,-54,-21,-3,6,12,19,20,74,92]
```

Now, below each element, I shall write True(T) or False(F) depending on the following condition:

**If nums[index] < 0, I will mark as true (T) else I mark as false (F)**

```rust
So, how does it look now?Index->012345678910nums=[-101,-99,-54,-21,-3,6,12,19,20,74,92]Bool->TTTTTFFFFFF
```

Now, if somehow we were able to find first index which we marked as false (F), would we able to get our answer?

Turns out that yes, we can. Since, false indicates that it is not negative and first false means that all elements to the left are negative. So, how many of them? The index itself. Didn't get it? What is the index of first F for above nums? It's 5 right. So the answer is 5. You can verify it.

#### Outcome: (Visualizing an array as this is important)

**What's important is that we think of binary search array as some array with**

1. **Prefixes of True(T) and Suffixes of False(F) OR**
2. **Prefixes of False (F) and Suffixes of True(T) OR**
3. **All True(T)**
4. **All False(F)**

**And how to derive these true or false values. It's through the conditions given in the question and it's easy to think about. You will realize that there are various ways to frame the conditions for true/false and all are correct.**

### Common mistakes/doubts in binary search :

- When to exit the loop? Should we use `left < right` or `left <= right` as the while loop condition?
- How to initialize the boundary variable `left` and `right`?
- How to update the boundary? How to choose the appropriate combination from `left = mid` , `left = mid + 1` and `right = mid`, `right = mid - 1`?

Base Template for binary search : 

```python
def binary_search(array) -> int:
    def condition(value) -> bool:
        pass

    left, right = min(search_space), max(search_space) # could be [0, n], [1, n] etc. Depends on problem
    while left < right:
        mid = left + (right - left) / 2
        if condition(mid):
            right = mid
        else:
            left = mid + 1
    return left
```

- Correctly initialize the boundary variables `left` and `right` to specify search space. Only one rule: set up the boundary to **include all possible elements**;
- Decide return value. Is it `return left` or `return left - 1`? Remember this: **after exiting the while loop, `left` is the minimal k satisfying the `condition` function**;
- Design the `condition` function.

#### As for the question "When can we use binary search?", my answer is that, If we can discover some kind of monotonicity, for example, if `condition(k) is True` then `condition(k + 1) is True`, then we can consider binary search.

### Binary Search on Answers

```python
int left = minPossibleAnswer;
int right = maxPossibleAnswer;

while (left < right) {
    int mid = left + (right - left) / 2;
    if (feasible(mid)) {
        right = mid;        // mid could be the answer, but try smaller
    } else {
        left = mid + 1;     // mid is too small, discard it
    }
}
return left;  // left == right == exact answer
```

# Binary Search on Answer — Complete Guide

---

## The Core Idea

Most people think binary search only works on sorted arrays to find a value. But there's a more powerful pattern:

> **Instead of searching for a value in an array, you search for the ANSWER itself in a range of possible answers.**
> 

The key insight is this — if you can answer the question:

> *"Is X a valid answer?"*
> 

...and the answer transitions cleanly from `False → True` (or `True → False`) as X increases, then you can binary search on X directly.

---

## The Universal Template

Every single problem in this pattern uses this identical structure:

```java
int left = minPossibleAnswer;
int right = maxPossibleAnswer;

while (left < right) {
    int mid = left + (right - left) / 2;
    if (feasible(mid)) {
        right = mid;        // mid could be the answer, but try smaller
    } else {
        left = mid + 1;     // mid is too small, discard it
    }
}
return left;  // left == right == exact answer
```

The only thing that changes between problems is:

- What `left` and `right` are initialized to
- How `feasible()` is implemented

---

## Problem 1 — Koko Eating Bananas (Medium)

### Problem

Piles of bananas. Koko eats at speed K per hour. Find **minimum K** to finish all piles in H hours.

### Monotonicity

```
Speed 1  → takes 100 hours  (too slow) ✗
Speed 2  → takes 60 hours   (too slow) ✗
Speed 4  → takes 8 hours    (just enough) ✓
Speed 10 → takes 4 hours    (works, but not minimum) ✓
Speed 20 → takes 2 hours    (works, but not minimum) ✓

False False False ✓ ✓ ✓ ✓ ✓
              ^
         find this boundary
```

### Search Space

- **Left (min speed):** 1 — she must eat at least 1 banana/hour
- **Right (max speed):** max(piles) — eating faster than the biggest pile is wasteful

### Feasibility Check

At speed `k`, hours needed for one pile = `ceil(pile / k)`:

```java
boolean feasible(int[] piles, int speed, int H) {
    int hours = 0;
    for (int pile : piles)
        hours += (pile + speed - 1) / speed;  // ceil division
    return hours <= H;
}
```

### Dry Run

`piles = [3,6,7,11], H = 8`

```
left=1, right=11

mid=6 → hours = ceil(3/6)+ceil(6/6)+ceil(7/6)+ceil(11/6) = 1+1+2+2 = 6 ≤ 8 ✓ → right=6
mid=3 → hours = ceil(3/3)+ceil(6/3)+ceil(7/3)+ceil(11/3) = 1+2+3+4 = 10 > 8 ✗ → left=4
mid=5 → hours = 1+2+2+3 = 8 ≤ 8 ✓ → right=5
mid=4 → hours = 1+2+2+3 = 8 ≤ 8 ✓ → right=4

left == right == 4 → answer: 4 ✓
```

---

## Problem 2 — Split Array Largest Sum (Hard)

### Problem

Split array into `m` subarrays. Minimize the **largest subarray sum**.

### Reframing (this is the key step)

Instead of asking *"how do I split optimally?"*, ask:

> *"If I set a limit of X on the max subarray sum, can I split within m parts?"*
> 

### Monotonicity

```
Limit 10 → need 5 parts (too many splits) ✗
Limit 14 → need 3 parts ✗
Limit 18 → need 2 parts ✓
Limit 25 → need 1 part  ✓

✗ ✗ ✗ ✓ ✓ ✓
        ^
   find this (minimum valid limit)
```

### Search Space

- **Left:** `max(nums)` — every part must hold at least the largest element
- **Right:** `sum(nums)` — one part holds everything

### Feasibility Check

Greedily accumulate into current subarray. When adding next element exceeds threshold, start a new part:

```java
boolean feasible(int[] nums, int threshold, int m) {
    int parts = 1, total = 0;
    for (int num : nums) {
        total += num;
        if (total > threshold) {   // current part exceeded limit
            total = num;           // start new part with current number
            parts++;
            if (parts > m)
                return false;
        }
    }
    return true;
}
```

### Dry Run

`nums = [7,2,5,10,8], m = 2`

```
left=10, right=32

mid=21 → parts: [7,2,5] [10,8] → 2 parts ≤ 2 ✓ → right=21
mid=15 → parts: [7,2,5] [10] [8] → 3 parts > 2 ✗ → left=16
mid=18 → parts: [7,2,5] [10,8] → 2 parts ≤ 2 ✓ → right=18
mid=17 → parts: [7,2,5] [10] [8] → 3 parts > 2 ✗ → left=18

left == right == 18 → answer: 18 ✓
```

---

## Problem 3 — Minimum Days to Make Bouquets (Medium)

### Problem

Flowers bloom on different days. Need `m` bouquets, each needing `k` **adjacent** bloomed flowers. Find minimum days to wait.

### Monotonicity

```
Day 1  → only 1 flower bloomed → can't make enough ✗
Day 3  → 3 flowers bloomed (non-adjacent issues) → maybe ✗
Day 10 → all bloomed → definitely enough ✓

✗ ✗ ✗ ✓ ✓ ✓
        ^
   find this
```

### Early Impossibility Check

```java
if (bloomDay.length < m * k) return -1;
// Not enough flowers even if all bloom
```

### Feasibility Check

Walk through garden. Count consecutive bloomed flowers. Every time you collect k consecutive ones, you have a bouquet:

```java
boolean feasible(int[] bloomDay, int days, int m, int k) {
    int bouquets = 0, flowers = 0;
    for (int bloom : bloomDay) {
        if (bloom > days) {
            flowers = 0;           // this flower hasn't bloomed, reset streak
        } else {
            flowers++;
            if (flowers == k) {    // collected k adjacent flowers
                bouquets++;
                flowers = 0;       // start fresh for next bouquet
            }
        }
    }
    return bouquets >= m;
}
```

### Dry Run

`bloomDay = [1,10,3,10,2], m=3, k=1`

```
left=1, right=10

mid=5  → bloomed: [1,_,3,_,2] → 3 bouquets ✓ → right=5
mid=3  → bloomed: [1,_,3,_,2] → 3 bouquets ✓ → right=3
mid=2  → bloomed: [1,_,_,_,2] → 2 bouquets ✗ → left=3

left == right == 3 → answer: 3 ✓
```

---

## Problem 4 — Kth Smallest in Multiplication Table (Hard)

### Problem

In an `m×n` multiplication table, find the Kth smallest number.

### Why not a Heap?

A heap would require generating all `m×n` values explicitly — O(mn) space. Binary search needs O(1) space.

### Reframing

> *"How many numbers in the table are ≤ X?"*
> 

If count ≥ k, X is a valid candidate for the answer.

### Key Observation

Row `i` contains: `i, 2i, 3i ... ni`. Numbers ≤ X in row `i` = `min(X/i, n)`:

```
Table m=3, n=3, query X=5:
Row 1: [1,2,3] → numbers ≤ 5: min(5/1, 3) = 3
Row 2: [2,4,6] → numbers ≤ 5: min(5/2, 3) = 2
Row 3: [3,6,9] → numbers ≤ 5: min(5/3, 3) = 1
Total = 6 numbers ≤ 5, and k=5, so 5 is valid ✓
```

```java
boolean enough(int m, int n, int num, int k) {
    int count = 0;
    for (int i = 1; i <= m; i++) {
        int add = Math.min(num / i, n);
        if (add == 0) break;       // rows beyond this have no valid numbers
        count += add;
    }
    return count >= k;
}
```

### Search Space

- **Left:** 1
- **Right:** m × n (largest value in table)

---

## Problem 5 — Kth Smallest Pair Distance (Hard)

### Problem

Given array, find Kth smallest **absolute difference** among all pairs.

### Reframing

> *"How many pairs have distance ≤ X?"*
> 

### Counting pairs efficiently

Sort the array. Use sliding window — for each right pointer `j`, find leftmost `i` where `arr[j] - arr[i] ≤ distance`. All elements between i and j form valid pairs with j:

```java
boolean enough(int[] nums, int distance, int k) {
    int count = 0, left = 0;
    for (int right = 1; right < nums.length; right++) {
        while (nums[right] - nums[left] > distance)
            left++;
        count += right - left;   // all pairs (left..right-1, right)
    }
    return count >= k;
}
```

### Search Space

- **Left:** 0 (minimum possible distance)
- **Right:** `max - min` (maximum possible distance)

---

## The Pattern Recognition Guide

When you see a problem, ask these questions in order:

```
1. Am I looking for a MINIMUM value that satisfies some condition?
   OR a MAXIMUM value?
        ↓ YES
2. If I pick any value X, can I efficiently check "is X valid?"
        ↓ YES
3. Is there a clear monotonicity?
   (once X works, all larger X also work — or vice versa)
        ↓ YES
→ Binary Search on Answer
```

### Common triggers in problem statements

| Phrase | Likely pattern |
| --- | --- |
| "minimum maximum" | Binary search on answer |
| "maximum minimum" | Binary search on answer |
| "minimum days/speed/divisor" | Binary search on answer |
| "Kth smallest" | Binary search + counting function |
| "at least / at most k" | Binary search on answer |

---

## Side-by-side Summary

| Problem | Search Space | Feasibility Question |
| --- | --- | --- |
| Koko Bananas | `[1, max(piles)]` | Can she finish in H hours at this speed? |
| Split Array | `[max(nums), sum(nums)]` | Can array split into ≤ m parts under this limit? |
| Bouquets | `[1, max(bloomDay)]` | Can we make m bouquets by this day? |
| Multiplication Table Kth | `[1, m×n]` | Are there ≥ k numbers ≤ this value? |
| Pair Distance Kth | `[0, max-min]` | Are there ≥ k pairs with distance ≤ this? |

The template never changes. Only the feasibility function does.
