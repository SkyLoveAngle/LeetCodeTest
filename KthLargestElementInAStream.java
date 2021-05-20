package leetcode.editor.cn;

//设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，
//不是第 k 个不同的元素。
//
// 请实现 KthLargest 类：
// KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。 
// int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。 

// 示例：
//输入：
//["KthLargest", "add", "add", "add", "add", "add"]
//[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
//输出：
//[null, 4, 5, 5, 8, 8]
//
//解释：
//KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
//kthLargest.add(3);   // return 4
//kthLargest.add(5);   // return 5
//kthLargest.add(10);  // return 5
//kthLargest.add(9);   // return 8
//kthLargest.add(4);   // return 8

//提示：
// 1 <= k <= 104 
// 0 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// -104 <= val <= 104 
// 最多调用 add 方法 104 次 
// 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素 
// 
// Related Topics 堆 设计 
// 👍 257 👎 0

public class KthLargestElementInAStream{
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAStream().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class KthLargest {
    //小顶堆
    private PriorityQueue<Integer> heap = null;
    private int k = 0;

    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.k = k;
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //先把堆填满（大小为k）
            if (heap.size() < k) {
                heap.offer(nums[i]);
            }
            //填满后，如果数组的值比堆顶大，去掉堆顶，然后把数组的值放到堆中（堆顶为最小值，也是第k大元素）
            else if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
    }
    
    public int add(int val) {
//如果堆没满，直接放入
        if (heap.size() < k) {
            heap.offer(val);
        }
        //如果堆满了，比较添加的值和堆顶的大小
        else if (val > heap.peek()) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}