package leetcode.editor.cn;

//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
// 示例 1：
// 输入："ab-cd"
//输出："dc-ba"
//
// 示例 2：
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
//
// 示例 3：
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 提示：
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S 中不包含 \ or "
// Related Topics 字符串 
// 👍 73 👎 0

public class ReverseOnlyLetters{
    public static void main(String[] args) {
        Solution solution = new ReverseOnlyLetters().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String str) {
        char[] chArray = str.toCharArray();
        int left = 0;
        int right = chArray.length - 1;
        while (left < right) {
            while (left < chArray.length && Character.isLetter(chArray[left])==false) {
                left++;
            }
            while (right >= 0 && Character.isLetter(chArray[right])==false) {
                right--;
            }
            if (left < right) {
                char temp = chArray[left];
                chArray[left] = chArray[right];
                chArray[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chArray);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}