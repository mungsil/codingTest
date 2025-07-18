

# 🧱 Implement Stack using Queues

Implement a **last-in-first-out (LIFO)** stack using **only two queues**.
The implemented stack should support all the functions of a normal stack:

* `push`, `top`, `pop`, and `empty`.

---

## ✏️ Class Definition

### `MyStack`

| Method             | Description                                                 |
| ------------------ | ----------------------------------------------------------- |
| `void push(int x)` | Pushes element `x` to the top of the stack.                 |
| `int pop()`        | Removes the element on the top of the stack and returns it. |
| `int top()`        | Returns the element on the top of the stack.                |
| `boolean empty()`  | Returns `true` if the stack is empty, `false` otherwise.    |

---

## 📌 Constraints

* Only **standard queue operations** are allowed:

  * push to back
  * peek/pop from front
  * size
  * is empty

* You can simulate a queue using `list` or `deque` as long as you use only queue-standard operations.

---

## 🧪 Example

```plaintext
Input:
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]

Output:
[null, null, null, 2, 2, false]
```

### Explanation:

```java
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top();    // return 2
myStack.pop();    // return 2
myStack.empty();  // return false
```

---

## ✅ Constraints

* `1 <= x <= 9`
* At most `100` calls will be made to `push`, `pop`, `top`, and `empty`.
* All calls to `pop` and `top` are **valid** (i.e., the stack is not empty when those are called).


