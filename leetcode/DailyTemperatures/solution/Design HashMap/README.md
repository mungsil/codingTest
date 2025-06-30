
## 🧩 Problem: 706. Design HashMap

Design a **HashMap** without using any built-in hash table libraries.

### ✨ Implement the `MyHashMap` class:

```java
MyHashMap() // Initializes the object with an empty map.

void put(int key, int value)
  // Inserts a (key, value) pair into the HashMap.
  // If the key already exists, update the corresponding value.

int get(int key)
  // Returns the value to which the specified key is mapped,
  // or -1 if this map contains no mapping for the key.

void remove(int key)
  // Removes the key and its corresponding value if present.
```

---

### 🧪 Example

**Input:**

```
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
```

**Output:**

```
[null, null, null, 1, -1, null, 1, null, -1]
```

**Explanation:**

```java
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1);    // The map is now [[1,1]]
myHashMap.put(2, 2);    // The map is now [[1,1], [2,2]]
myHashMap.get(1);       // return 1
myHashMap.get(3);       // return -1 (not found)
myHashMap.put(2, 1);    // update the value for key 2
myHashMap.get(2);       // return 1
myHashMap.remove(2);    // remove key 2
myHashMap.get(2);       // return -1 (not found)
```

---

### ✅ Constraints

* `0 <= key, value <= 10⁶`
* At most `10⁴` calls will be made to `put`, `get`, and `remove`.

