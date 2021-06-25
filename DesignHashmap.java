package leetcode.editor.cn;
//不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
//实现 MyHashMap 类：
//MyHashMap() 用空映射初始化对象
//void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。
//如果 key 已经存在于映射中，
//则更新其对应的值 value 。 
//int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
//void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。

//示例：
//输入：
//["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
//输出：
//[null, null, null, 1, -1, null, 1, null, -1]
//
//解释：
//MyHashMap myHashMap = new MyHashMap();
//myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
//myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
//myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
//myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
//myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]

// 提示：
// 0 <= key, value <= 106 
// 最多调用 104 次 put、get 和 remove 方法
// 进阶：你能否不使用内置的 HashMap 库解决此问题？ 
// Related Topics 设计 哈希表 
// 👍 181 👎 0

public class DesignHashmap{
    public static void main(String[] args) {
        Solution solution = new DesignHashmap().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
//class MyHashMap {
//    /** Initialize your data structure here. */
//    public MyHashMap() {
//    }
//    /** value will always be non-negative. */
//    public void put(int key, int value) {
//    }
//    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//    public int get(int key) {
//    }
//    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//    public void remove(int key) {
//    }
//}

    class MyHashMap {
        static class Node {
            int key, value;
            Node next;
            Node(int _key, int _value) {
                key = _key;
                value = _value;
            }
        }

        // 由于使用的是「链表」，这个值可以取得很小
        Node[] nodes = new Node[10009];

        public void put(int key, int value) {
            // 根据 key 获取哈希桶的位置
            int idx = getIndex(key);
            // 判断链表中是否已经存在
            Node loc = nodes[idx], tmp = loc;
            if (loc != null) {
                Node prev = null;
                while (tmp != null) {
                    if (tmp.key == key) {
                        tmp.value = value;
                        return;
                    }
                    prev = tmp;
                    tmp = tmp.next;
                }
                tmp = prev;
            }
            Node node = new Node(key, value);

            // 头插法
            // node.next = loc;
            // nodes[idx] = node;

            // 尾插法
            if (tmp != null) {
                tmp.next = node;
            } else {
                nodes[idx] = node;
            }
        }

        public void remove(int key) {
            int idx = getIndex(key);
            Node loc = nodes[idx];
            if (loc != null) {
                Node prev = null;
                while (loc != null) {
                    if (loc.key == key) {
                        if (prev != null) {
                            prev.next = loc.next;
                        } else {
                            nodes[idx] = loc.next;
                        }
                        return;
                    }
                    prev = loc;
                    loc = loc.next;
                }
            }
        }

        public int get(int key) {
            int idx = getIndex(key);
            Node loc = nodes[idx];
            if (loc != null) {
                while (loc != null) {
                    if (loc.key == key) {
                        return loc.value;
                    }
                    loc = loc.next;
                }
            }
            return -1;
        }

        int getIndex(int key) {
            // 因为 nodes 的长度只有 10009，对应的十进制的 10011100011001（总长度为 32 位，其余高位都是 0）
            // 为了让 key 对应的 hash 高位也参与运算，这里对 hashCode 进行右移异或
            // 使得 hashCode 的高位随机性和低位随机性都能体现在低 16 位中
            int hash = Integer.hashCode(key);
            hash ^= (hash >>> 16);
            return hash % nodes.length;
        }
    }


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}