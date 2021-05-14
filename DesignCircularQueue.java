package leetcode.editor.cn;

//设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则
//并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
//循环队列的一个好处是我们可以利用这个队列之前用过的空间。
//在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。
//但是使用循环队列，我们能使用这些空间去存储新的值。
//
// 你的实现应该支持如下操作：
// MyCircularQueue(k): 构造器，设置队列长度为 k 。 
// Front: 从队首获取元素。如果队列为空，返回 -1 。 
// Rear: 获取队尾元素。如果队列为空，返回 -1 。 
// enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。 
// deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。 
// isEmpty(): 检查循环队列是否为空。 
// isFull(): 检查循环队列是否已满。 

// 示例：
// MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
//circularQueue.enQueue(1);  // 返回 true
//circularQueue.enQueue(2);  // 返回 true
//circularQueue.enQueue(3);  // 返回 true
//circularQueue.enQueue(4);  // 返回 false，队列已满
//circularQueue.Rear();  // 返回 3
//circularQueue.isFull();  // 返回 true
//circularQueue.deQueue();  // 返回 true
//circularQueue.enQueue(4);  // 返回 true
//circularQueue.Rear();  // 返回 4 
//
// 
//
// 提示： 
//
// 
// 所有的值都在 0 至 1000 的范围内； 
// 操作数将在 1 至 1000 的范围内； 
// 请不要使用内置的队列库。 
// 
// Related Topics 设计 队列 
// 👍 173 👎 0

public class DesignCircularQueue{
    public static void main(String[] args) {
        Solution solution = new DesignCircularQueue().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /*
     对于一个固定大小的数组，任何位置都可以是队首，只要知道队列长度，
     就可以根据下面公式计算出队尾位置：tailIndex = (headIndex + count − 1) mod capacity
     其中 capacity 是数组长度，count 是队列长度，headIndex 和 tailIndex 分别是
     队首 head 和队尾 tail 索引。
    */


/*
    class MyCircularQueue {
    //使用数组的方法：
        int[] queue;
        int headIndex;
        int count;
        int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;//循环队列的容量，即队列中最多可以容纳的元素数量。
        this.queue = new int[k];//一个固定大小的数组，用于保存循环队列的元素。
        this.headIndex = 0;//一个整数，保存队首 head 的索引。
        this.count = 0;//循环队列当前的长度，即循环队列中的元素数量。
        // 使用 hadIndex 和 count 可以计算出队尾元素的索引，因此不需要队尾属性。
    }
    
    public boolean enQueue(int value) {
        if (this.count == this.capacity){
            return false;
        }
        this.queue[(this.headIndex + this.count) % this.capacity] = value;
        this.count ++;
        return true;
    }
    
    public boolean deQueue() {
        if (this.count == 0) {
            return false;
        }
        this.headIndex = (this.headIndex + 1) % this.capacity;
        this.count --;
        return true;
    }
    
    public int Front() {
        if (this.count == 0) {
            return -1;
        }
        return this.queue[this.headIndex];
    }
    
    public int Rear() {
        if (this.count == 0) {
            return -1;
        }
        int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
        return this.queue[tailIndex];
    }
    
    public boolean isEmpty() {
        return (this.count == 0);
    }
    
    public boolean isFull() {
        return (this.count == this.capacity);
    }
}
 */

//用链表实现

    class MyCircularQueue {

        private Node head, tail;
        private int count;
        private int capacity;
        // Additional variable to secure the access of our queue
        private ReentrantLock queueLock = new ReentrantLock();

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            this.capacity = k;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            // ensure the exclusive access for the following block.
            queueLock.lock();
            try {
                if (this.count == this.capacity)
                    return false;

                Node newNode = new Node(value);
                if (this.count == 0) {
                    head = tail = newNode;
                } else {
                    tail.nextNode = newNode;
                    tail = newNode;
                }
                this.count += 1;

            } finally {
                queueLock.unlock();
            }
            return true;
        }

    }




/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}