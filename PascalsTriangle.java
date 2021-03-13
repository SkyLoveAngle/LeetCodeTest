package leetcode.editor.cn;

//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
// 示例:
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组
public class PascalsTriangle{
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ret  = new ArrayList<>();

        if(numRows == 0) {
            return ret;
        }
        List<Integer> oneRow = new ArrayList<>();
        ret.add(oneRow);
        ret.get(0).add(1);//第一行的元素 添加了一个1
        //直接从第2行开始进行计算
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);//当前行的第一个元素
            List<Integer> prevRow = ret.get(i-1);//前一行
            for(int j = 1; j < i;j++) {
                //[i,j] = [i-1,j] +[i-1,j-1]
                int x = prevRow.get(j);
                int y = prevRow.get(j-1);
                curRow.add(x+y);
            }
            //最后一个元素
            curRow.add(1);
            ret.add(curRow);
        }
        return ret;
    }
}

/*
    public static void main(String[] args) {
        List<List<Integer>> lists = generate(3);
        for (List<Integer> tmp:lists) {
            System.out.println(tmp);
        }
    }
*/

//leetcode submit region end(Prohibit modification and deletion)

}