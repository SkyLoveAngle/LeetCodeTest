package leetcode.editor.cn;

//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
//数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1:
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下
// 一个更大的数；
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈 
// 👍 397 👎 0

public class NextGreaterElementIi{
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {

        //单调栈+循环数组
//        int length = nums.length;
//        int res[] = new int[length];
//        Arrays.fill(res, -1);//默认都为-1
//        Stack<Integer> stack = new Stack<>();
//        //相当于把数组循环两遍
//        for (int i = 0; i < length * 2; i++) {
//            //遍历数组的第index（index从0开始）个元素，因为数组会遍历两遍，
//            //会导致数组越界异常，所以这里要对数组长度进行求余
//            int index = i % length;
//            /*
//            单调栈，他存储的是元素的下标，不是元素具体值，从栈顶到栈底所对应的值是递增的
//            （栈顶元素在数组中对应的值最小，栈底元素对应的值最大），
//            如果栈顶元素对应的值比nums[index]小，说明栈顶元素对应的值遇到了右边第一个
//            比他大的值，然后栈顶元素出栈，让他对应的位置变为nums[index]，
//            也就是他右边第一个比他大的值，然后继续判断……
//             */
//            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
//                res[stack.pop()] = nums[index];
//            }
//            //当前元素的下标入栈
//            stack.push(index);
//        }
//        return res;
//    }


    //暴力解题(例子：12135)
        int n = 2* nums.length;
        int[] res = new int[n/2];
        for(int i=0;i<n/2;i++){
            int cur = nums[i];
            int nextBig = -1;
            for(int j=1;j<n;j++){
                if(nums[j%(n/2)]>cur){
                    nextBig = nums[j%(n/2)];
                    break;
                }
            }
            res[i] = nextBig;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}