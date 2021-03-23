package leetcode.editor.cn;

//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
// 示例 1：
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。 
//
// 示例 2：
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。

// 示例 3：
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指第三大且唯一出现的数。
//存在两个值为2的数，它们都排第二。
// 提示：
// 1 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？ 
// Related Topics 数组 
// 👍 198 👎 0

public class ThirdMaximumNumber{
    public static void main(String[] args) {
        Solution solution = new ThirdMaximumNumber().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int thirdMax(int[] arr) {
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        for (int num : arr) {
            max1 = Math.max(max1, num);
        }
        for (int num : arr) {
            if (num == max1) {
                continue;
            }
            max2 = Math.max(max2, num);
        }
        for (int num : arr) {
            if (num == max1||num==max2) {
                continue;
            }
            max3 = Math.max(max3, num);
        }
        return (int) (max3 == Long.MIN_VALUE ? max1 : max3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}