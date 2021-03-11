package leetcode.editor.cn;

//实现 int sqrt(int x) 函数。计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 563 👎 0

public class Sqrtx{
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
 /*       if(x==0 || x==1){
            return x;
        }
        long start = 1;
        long end  = (x>>1)+1;
        while(start <= end){
            long mid = (start + end) >> 1;
            long res = mid * mid;
            if(res == x){
                return (int)mid;
            }
            if(res > x){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return (int)end;
    }
}
*/
 /*
 利用平方数的性质。连续n个奇数相加的结果一定是平方数。例如：
9 = 1+3+5 ， 一共3个奇数相加，所以32= 9
16 = 1+3+5+7，一共4个奇数相加，所以42=16
  */
        int i = 1;
        int res = 0;
        while (x >= 0) {
            x -= i;
            ++res;
            i += 2;
        }
        return res - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}