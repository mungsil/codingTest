

## 📘 75. Sort Colors

> **Difficulty**: Medium
> **Tag**: Array, Two Pointers, Sorting

---

### 🧩 Problem

Given an array `nums` with `n` objects colored **red**, **white**, or **blue**, sort them **in-place** so that objects of the same color are adjacent, with the colors in the order **red**, **white**, and **blue**.

We will use the integers:

* `0` to represent red,
* `1` to represent white,
* `2` to represent blue.

You must solve this problem **without** using the library's sort function.

---

### 💡 Constraints

* `1 <= nums.length <= 300`
* `nums[i]` is either `0`, `1`, or `2`.

---

### 🧪 Examples

#### Example 1

```
Input:  nums = [2, 0, 2, 1, 1, 0]
Output: [0, 0, 1, 1, 2, 2]
```

#### Example 2

```
Input:  nums = [2, 0, 1]
Output: [0, 1, 2]
```

---

### 🚫 Restrictions

* Do **not** use built-in sort functions like `Arrays.sort()` or `Collections.sort()`.

