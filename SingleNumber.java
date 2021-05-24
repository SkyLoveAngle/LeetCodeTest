package leetcode.editor.cn;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
//找出那个只出现了一次的元素。
//
// 说明：
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1:
// 输入: [2,2,1]
//输出: 1

// 示例 2:
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1775 👎 0

public class SingleNumber{
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
//        //key 表示当前数字是谁, value 表示该数字出现几次
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int x : nums) {
//            Integer value = map.get(x);
//            if (value == null) {
//                // 如果 x 不存在, 就插入新的键值对. value 就记为 1
//                map.put(x, 1);
//            } else {
//                // 如果 x 存在, 就在原来的 value 的基础上再 +1
//                map.put(x, value + 1);
//            }
//        }
//        // 此时 map 里面就包含了每个数字出现多少次
//        // 遍历 map 即可, 找出那个只出现一次的数字
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue().equals(1)) {
//                return entry.getKey();
//            }
//        }
//        return 0;



        int singleDog = 0;
        for (int x : nums) {
            singleDog ^= x;
        }
        return singleDog;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}