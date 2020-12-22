package leetcode.editor.cn;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    //暴力法很简单，遍历每个元素 xx，并查找是否存在一个值与 target - xtarget−x 相等的目标元素。
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] + nums[i]) == target)  {
                        return new int[] { i, j };
                    }
                }
            }
        // 当数组中没有符合要求的两个元素时，抛出异常
            throw new IllegalArgumentException("No two sum solution");
        }
    }

}