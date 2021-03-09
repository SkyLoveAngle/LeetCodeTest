package leetcode.editor.cn;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2412 👎 0

public class ReverseInteger{
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        long temp = 0;//中间变量，32位即4个字节，考虑溢出，我们用long；
        while(x != 0){
            long rev = temp*10;
            temp = rev + x%10;//反转就是将最低位变为最高位，最高位变为最低位
            x/=10;//目的是从最高位逐渐往下变
        }
        if(temp<Integer.MIN_VALUE || temp>Integer.MAX_VALUE){//判断temp是否有溢出现象
            return 0;
        }
        return (int)temp;//最后满足条件的转换成我们int类型
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}