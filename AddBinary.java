package leetcode.editor.cn;

//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 

// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 550 👎 0

public class AddBinary{
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuffer s = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;   //进位
        for( ;i >= 0||j >= 0; i--,j-- )
        {
            int a1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int b1 = j >= 0 ? b.charAt(j) - '0' : 0;
            int tmp = a1 + b1 + c;

            if(tmp < 2)   //小于2  没有产生进位
            {
                s.append(tmp + "");
                c = 0;
            }
            else if(tmp == 2)  //进位为 1 ，本位为0
            {
                s.append("0");
                c = 1;
            }
            else
            {
                s.append("1"); //进位为 1 ，本位 为 1
                c = 1;
            }
        }
        if(c == 1)
        {
            s.append("1");
        }
        return Reverse(s.toString());// 用逆序方法逆序
    }
    public String Reverse(String s)
    {
        char[] chars = s.toCharArray();
        int i = 0;
        int len = s.length() - 1;
        while(i < len)
        {
            char tmp = chars[i];
            chars[i] = chars[len];
            chars[len] = tmp;
            i ++;
            len --;
        }
        return String.valueOf(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}