package leetcode.editor.cn;

//你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
//空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的
//一对一映射关系的空括号对。
//
//示例 1:
//输入: 二叉树: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /    
//  4     
//
//输出: "1(2(4))(3)"
//
//解释: 原本将是“1(2(4)())(3())”，
//在你省略所有不必要的空括号对之后，
//它将是“1(2(4))(3)”。
// 
//
// 示例 2:
//输入: 二叉树: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \  
//      4 
//
//输出: "1(2()(4))(3)"
//解释: 和第一个示例相似，
//除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
// 
// Related Topics 树 字符串 
// 👍 184 👎 0

public class ConstructStringFromBinaryTree{
    public static void main(String[] args) {
        Solution solution = new ConstructStringFromBinaryTree().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
省略（）的规则：
1.如果左右子树都为空，则（）可以省略
2.如果左子树为空，右子树为非空，则（）可以省略
3.如果左子树为空，右子树为非空，则（）不可以省略
 */
class Solution {
    // 需要在递归过程中, 把当前的结果添加到 stringBuilder 里头
    public StringBuilder stringBuilder = null;
    public String tree2str(TreeNode t) {
        // 为了防止多个用例之间相互影响, 就需要每次进入方法都去重新初始化
        stringBuilder = new StringBuilder();
        if (t == null) {
            return "";
        }
        // 搞一个辅助递归的方法来完成
        _tree2str(t);

        // 把最外层括号给删掉
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

    public void _tree2str(TreeNode root) {
        if (root == null) {
            return;
        }

        // 先序遍历. 访问操作是把元素插入到 stringBuilder 里面
        stringBuilder.append("(");
        stringBuilder.append(root.val);

        _tree2str(root.left);
        if (root.left == null && root.right != null) {
            stringBuilder.append("()");
        }

        _tree2str(root.right);

        stringBuilder.append(")");
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}