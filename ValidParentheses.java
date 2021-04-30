package leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
// 有效字符串需满足：
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1:
// 输入: "()"
//输出: true
//
// 示例 2:
// 输入: "()[]{}"
//输出: true
//
// 示例 3:
// 输入: "(]"
//输出: false
//
// 示例 4:
// 输入: "([)]"
//输出: false
//
// 示例 5:
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 


public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(')');
            }else if(c== '{'){
                stack.push('}');
            }else if(c=='['){
                stack.push(']');
            }else if(stack.isEmpty() || c!=stack.pop()){
                //否则就只能是右括号。
                //1，如果栈为空，说明括号无法匹配。
                //2，如果栈不为空，栈顶元素就要出栈，和这个右括号比较。
                //如果栈顶元素不等于这个右括号，说明无法匹配，
                //直接返回false
               return false;
            }
        }
        //最后如果栈为空，说明完全匹配，是有效的括号。
        //否则不完全匹配，就不是有效的括号
        return stack.isEmpty();
    }



}
//leetcode submit region end(Prohibit modification and deletion)

}