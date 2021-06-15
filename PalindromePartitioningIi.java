package leetcode.editor.cn;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
//返回符合要求的 最少分割次数 。

//示例 1：
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。

//示例 2：
//输入：s = "a"
//输出：0

//示例 3：
//输入：s = "ab"
//输出：1

// 提示：
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 

// Related Topics 动态规划 
// 👍 411 👎 0

public class PalindromePartitioningIi{
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningIi().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private boolean isPal(String s, int start, int end) {
            while (start < end){
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                ++ start;
                -- end;
            }
            return true;
        }

        public int minCut(String s) {
            int[] mincut = new int[s.length() + 1];
            //F(i) = i-1
            for (int i=0;i<=s.length();i++){
                mincut[i] = i-1;
            }

        for (int i=1;i<=s.length();i++){
            //判断整体
            if (isPal(s,0,i-1)){
                mincut[i] = 0;
                continue;
            }
            for (int j=0;j<i;j++){
                //j<i && [j+1,i]
                if (isPal(s,j,i-1)){
                    mincut[i] = Math.min(mincut[i],mincut[j]+1);
                }
            }
        }
        return mincut[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}