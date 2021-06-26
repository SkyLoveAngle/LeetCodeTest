package leetcode.editor.cn;

//给定仅有小写字母组成的字符串数组 A，
//返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
//例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
//你可以按任意顺序返回答案。

//示例 1：
//输入：["bella","label","roller"]
//输出：["e","l","l"]

//示例 2：
//输入：["cool","lock","cook"]
//输出：["c","o"]

// 提示：

// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 
// 👍 211 👎 0

public class FindCommonCharacters{
    public static void main(String[] args) {
        Solution solution = new FindCommonCharacters().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public List<String> commonChars(String[] A) {
        // 思路：统计每个字符出现次数，有一个单词未出现就置0输出所有单词中出现0次以上】
        // 存放26个字符在单词列表的每个单词中都出现的频率
        int[] minFreq = new int[26];
        // 填充max方便下降比较
        // 降到0就最小，说明该字符在某个单词中未出现，结果中也就不需要输出
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        // 遍历统计
        for (String word : A) {
            // 记录每个单词中各字符出现情况
            int[] freq = new int[26];
            int length = word.length();
            // 遍历单词
            for (int i = 0; i < length; i++) {
                // 统计某单词中字符出现情况
                char ch = word.charAt(i);
                // 累加字符出现次数
                ++freq[ch - 'a'];
            }
            // 统计完每个单词都去更新每个单词的最低出现频率
            for (int i = 0; i < 26; i++) {
                // 更新每个单词中每个字符出现的最少次数
                // 如果某个字符只在单个单词中出现自然这个字符计数会被置为0
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        // 汇总输出结果
        for (int i = 0; i < 26; i++) {
            // 如果某字符只在某个单词中出现或没出现那么频率会被将为0不被计入结果
            // 其他在每个单词中都出现的字符计数多次
            for (int j = 0; j < minFreq[i]; j++) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}