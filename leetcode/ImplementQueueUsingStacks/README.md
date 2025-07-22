
# 232. Implement Queue using Stacks

**Difficulty:** Easy
**Topics:** Stack, Queue
**Follow-up:** Can you implement the queue such that each operation is **amortized O(1)** time complexity?

---

## 📌 Problem Description

Implement a **first-in-first-out (FIFO) queue** using **only two stacks**.
The implemented queue should support all the functions of a normal queue:

### Methods to Implement

* `void push(int x)`: Pushes element `x` to the back of the queue.
* `int pop()`: Removes the element from the front of the queue and returns it.
* `int peek()`: Returns the element at the front of the queue.
* `boolean empty()`: Returns `true` if the queue is empty, `false` otherwise.

---

## 🧩 Notes

* You must use only **standard operations of a stack**:

  * Push to top
  * Peek/pop from top
  * Size
  * isEmpty
* Depending on your language, the stack may not be supported natively.
  You may simulate a stack using a **list or deque**, as long as you use **only stack operations**.

---

## 📘 Example

```text
Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]

Output
[null, null, null, 1, 1, false]
```

**Explanation:**

```java
MyQueue myQueue = new MyQueue();
myQueue.push(1);     // queue: [1]
myQueue.push(2);     // queue: [1, 2] (leftmost is front)
myQueue.peek();      // returns 1
myQueue.pop();       // returns 1, queue becomes [2]
myQueue.empty();     // returns false
```

---

## 🧷 Constraints

* `1 <= x <= 9`
* At most **100 calls** will be made to `push`, `pop`, `peek`, and `empty`.
* All calls to `pop` and `peek` are **valid** (i.e., the queue will not be empty when called).


