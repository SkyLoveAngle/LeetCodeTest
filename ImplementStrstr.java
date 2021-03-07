package leetcode.editor.cn;
//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 653 👎 0

public class ImplementStrstr{
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        // 子串为0就不用比较了，直接返回
        if (L == 0) return 0;
        // 母串指针
        int pn = 0;
        //
        while (pn < n - L + 1) {
            //根据子串首字母，查到母串与子串首字母相等的位置
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) {
                ++pn;
            }

            // 当前指针位置，和 子串的指针
            int currLen = 0, pL = 0;
            // 进行子串匹配，如果子串位置小于子串长度，并且母串位置小于母串长度，并且两者位置的字母相同，继续往下一个字母匹配
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }

            // 如果当前指针移到了子串结尾，证明匹配，直接返回
            if (currLen == L) return pn - L;

            // 当前的子串到尾部发现不匹配的话，则进行跳到第二个子串首字母的位置+1进行继续匹配，重新开始上面的循环
            pn = pn - currLen + 1;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}