package leetcode.editor.cn;

//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//你可以对一个单词进行如下三种操作：
//插入一个字符;删除一个字符;替换一个字符

// 示例 1： 

//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2：
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')

// 提示：
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 1543 👎 0

public class EditDistance{
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        // word与空串之间的编辑距离为word的长度
        if(word1.isEmpty() || word2.isEmpty())
            return Math.max(word1.length(), word2.length());
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] minDis = new int[len1 + 1][len2 + 1];
        // F(i,j)初始化
        for(int i = 0; i <= len1; ++i){
            minDis[i][0] = i;
        }
        for(int i = 0; i <= len2; ++i){
            minDis[0][i] = i;
        }
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                // F(i,j) = min { F(i-1,j）+1, F(i,j-1) +1, F(i-1,j-1) +(w1[i]==w2[j]?0:1) }
                minDis[i][j] = 1 + Math.min(minDis[i - 1][j], minDis[i][j - 1]);
                // 判断word1的第i个字符是否与word2的第j个字符相等
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    // 字符相等，F(i-1,j-1)编辑距离不变
                    minDis[i][j] = Math.min(minDis[i][j],minDis[i - 1][j - 1]);
                }
                else{
                    // 字符不相等，F(i-1,j-1)编辑距离 + 1
                    minDis[i][j] = Math.min(minDis[i][j],minDis[i - 1][j - 1] + 1);
                }
            }
        }
        return minDis[len1][len2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}