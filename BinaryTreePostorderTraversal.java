package leetcode.editor.cn;

//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 540 👎 0

public class BinaryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result =  new ArrayList<>();
        if (root == null){
            return result;  //这里当root为null需要返回的是result，尽量不要用null!
        }
        // 递归处理左子树, 此时会得到一个左子树的遍历结果的 List. 这个结果也要加入到 result 中
        result.addAll(postorderTraversal(root.left));
        // 递归处理右子树
        result.addAll(postorderTraversal(root.right));
        // 访问根节点. 此处的 "访问" 不是打印, 而是插入 result 末尾
        result.add(root.val);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}