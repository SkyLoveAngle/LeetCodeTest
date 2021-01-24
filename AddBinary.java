package leetcode.editor.cn;

//给你两个二进制字符串，返回它们的和（用二进制表示）。
// 输入为 非空 字符串且只包含数字 1 和 0。
// 示例 1:
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2:
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 提示：
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。

public class AddBinary{
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        if(a==null)
            return b;
        if(b==null)
            return a;
        String tempa="";
        for(int i=0;i<a.length();i++){
            tempa=a.charAt(i)+tempa;
        }
        a=tempa;
        String tempb="";
        for(int i=0;i<b.length();i++){
            tempb=b.charAt(i)+tempb;
        }
        b=tempb;
        String res="";
        int numa=0,numb=0,index=0;
        for(int i=0;i<a.length()||i<b.length()||index!=0;i++){
            if(i<a.length()){
                numa=Integer.parseInt(String.valueOf(a.charAt(i)));
            }
            else{
                numa=0;
            }
            if(i<b.length()){
                numb=Integer.parseInt(String.valueOf(b.charAt(i)));
            }
            else{
                numb=0;
            }
            if(numa+numb+index<2){
                res=String.valueOf(numa+numb+index)+res;
                index=0;
            }
            else{
                res=String.valueOf((numa+numb+index)%2)+res;
                index=1;
            }
        }
        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}