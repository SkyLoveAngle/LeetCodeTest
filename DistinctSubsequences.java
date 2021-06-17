package leetcode.editor.cn;

//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。 
//字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符
//且不干扰剩余字符相对位置所组成的新字符串。
//（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
//题目数据保证答案符合 32 位带符号整数范围。

//示例 1：
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。(上箭头符号 ^ 表示选取的字母)
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^

//示例 2：
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。(上箭头符号 ^ 表示选取的字母)
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^ 

// 提示：
// 0 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成
// Related Topics 字符串 动态规划
// 👍 507 👎 0

public class DistinctSubsequences{
    public static void main(String[] args) {
        Solution solution = new DistinctSubsequences().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
            public int numDistinct(String S, String T) {
                int sLen = S.length();
                int tLen = T.length();
                int[][] numDis = new int[sLen + 1][tLen + 1];
                numDis[0][0] = 1;
                // F(i,j)，初始化第一行剩余列的所有值为0
                for(int i = 1; i <= tLen; ++i){
                    numDis[0][i] = 0;
                }
                //F(i, 0) = 1
                for(int i = 1; i <= sLen; ++i){
                    numDis[i][0] = 1;
                }
                for(int i = 1; i <= sLen; ++i){
                    for(int j = 1; j <= tLen; ++j){
                        // S的第i个字符与T的第j个字符相同
                        if(S.charAt(i - 1) == T.charAt(j - 1)){
                            numDis[i][j] = numDis[i - 1][j] + numDis[i - 1][j - 1];
                        }
                        else{
                            // S的第i个字符与T的第j个字符不相同
                            // 从S的前i-1个字符中找子串，使子串与T的前j个字符相同
                            numDis[i][j] = numDis[i - 1][j];
                        }
                    }
                }
                return numDis[sLen][tLen];
            }
    }
//leetcode submit region end(Prohibit modification and deletion)

}