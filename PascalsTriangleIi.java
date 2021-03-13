package leetcode.editor.cn;

//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]

// 进阶：
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组

public class PascalsTriangleIi{
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        int[][] arr = new int[rowIndex + 1][rowIndex + 1];
        for(int i = 0;i<rowIndex + 1;i++){
            row.clear();
            for(int j = 0;j <= i;j++){
                if(j==0 || j==i){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
                row.add(arr[i][j]);
            }
        }
        return row;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}