package leetcode.editor.cn;

//你现在是一场采用特殊赛制棒球比赛的记录员。
//这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
//比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，
//其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：

// 整数 x - 表示本回合新获得分数 x 
// "+" - 表示本回合新获得的得分是前两次得分的总和。
// 题目数据保证记录此操作时前面总是存在两个有效的分数。
// "D" - 表示本回合新获得的得分是前一次得分的两倍。
// 题目数据保证记录此操作时前面总是存在一个有效的分数。
// "C" - 表示前一次得分无效，将其从记录中移除。
// 题目数据保证记录此操作时前面总是存在一个有效的分数。

// 请你返回记录中所有得分的总和。 

// 示例 1：
//输入：ops = ["5","2","C","D","+"]
//输出：30
//解释：
//"5" - 记录加 5 ，记录现在是 [5]
//"2" - 记录加 2 ，记录现在是 [5, 2]
//"C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
//"D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
//"+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
//所有得分的总和 5 + 10 + 15 = 30
// 
//
// 示例 2：
//输入：ops = ["5","-2","4","C","D","9","+","+"]
//输出：27
//解释：
//"5" - 记录加 5 ，记录现在是 [5]
//"-2" - 记录加 -2 ，记录现在是 [5, -2]
//"4" - 记录加 4 ，记录现在是 [5, -2, 4]
//"C" - 使前一次得分的记录无效并将其移除，记录现在是 [5, -2]
//"D" - 记录加 2 * -2 = -4 ，记录现在是 [5, -2, -4]
//"9" - 记录加 9 ，记录现在是 [5, -2, -4, 9]
//"+" - 记录加 -4 + 9 = 5 ，记录现在是 [5, -2, -4, 9, 5]
//"+" - 记录加 9 + 5 = 14 ，记录现在是 [5, -2, -4, 9, 5, 14]
//所有得分的总和 5 + -2 + -4 + 9 + 5 + 14 = 27
// 
//
// 示例 3：
//输入：ops = ["1"]
//输出：1

// 提示： 

// 1 <= ops.length <= 1000 
// ops[i] 为 "C"、"D"、"+"，或者一个表示整数的字符串。整数范围是 [-3 * 104, 3 * 104] 
// 对于 "+" 操作，题目数据保证记录此操作时前面总是存在两个有效的分数 
// 对于 "C" 和 "D" 操作，题目数据保证记录此操作时前面总是存在一个有效的分数 
// 
// Related Topics 栈 
// 👍 168 👎 0

public class BaseballGame{
    public static void main(String[] args) {
        Solution solution = new BaseballGame().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calPoints(String[] ops) {
        //用栈解决问题
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < ops.length ; i++) {
            if (ops[i].equals("C") ) {
                stack.removeLast(); //移除栈顶元素
            } else if (ops[i].equals("D")) {
                stack.addLast(stack.peekLast() * 2); //栈顶元素翻倍再加入栈
            } else if (ops[i].equals("+")) {
                int top = stack.pollLast(); //先弹出栈顶元素，便于找到第二个栈顶元素
                int top2 = stack.peekLast(); //第二个栈顶元素
                stack.addLast(top); //别忘了之前弹出过的栈顶元素，加回来
                stack.addLast(top+top2); //加入栈顶与第二个栈顶元素之和
            } else {
                stack.addLast(Integer.parseInt(ops[i])); //数字直接添加
            }
        }
        for (int n : stack) {
            res += n; //栈所有元素累加和
        }
        return res;

    }

    //普通数组解法
//        int length = ops.length;
//        int[] num = new int[length];
//        int index = 0;
//        for (int i=0;i<length;i++){
//            if (ops[i].equals("C")){
//                index--;
//                num[index]=0;
//            }
//            else if (ops[i].equals("D")){
//                num[index]=2*num[index-1];
//                index++;
//            }
//            else if (ops[i].equals("+")){
//                num[index] = num[index-2] + num[index-1];
//                index++;
//            }else{
//                num[index] = Integer.parseInt(ops[i]);//将字符串类型转换成整型类型
//                index++;
//            }
//        }
//
//        int sum=0;
//        for (int j=0;j<length;j++){
//            sum+=num[j];
//        }
//        return sum;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}