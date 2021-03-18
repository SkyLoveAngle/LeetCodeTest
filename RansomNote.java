package leetcode.editor.cn;

//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
//的字符构成。如果可以构成，返回 true ；否则返回 false。 
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。) 
//
// 
//
// 注意： 
//
// 你可以假设两个字符串均只含有小写字母。 
//
// canConstruct("a", "b") -> false
//canConstruct("aa", "ab") -> false
//canConstruct("aa", "aab") -> true
// 
// Related Topics 字符串 
// 👍 126 👎 0

public class RansomNote{
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
            char[] chars = magazine.toCharArray();
            if(ransomNote.length() > magazine.length()){
                return false;
            }
            for(int i = 0; i < ransomNote.length(); i++){
                int j = judge(chars, ransomNote.charAt(i));
                if(j != -1){
                    chars[j] = '0';
                }else{
                    return false;
                }
            }
            return true;
        }

        public static int judge(char[] chars,char a){
            for(int i = 0; i< chars.length;i++){
                if(a == chars[i]){
                    return i;
                }
            }
            return -1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}