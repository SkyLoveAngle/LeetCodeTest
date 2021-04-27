package leetcode.editor.cn;

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//示例 1：
//输入：root = [1,null,2,3]
//输出：[1,2,3]

//示例 2
//输入：root = []
//输出：[]

// 示例 3：
//输入：root = [1]
//输出：[1]

// 示例 4：
//输入：root = [1,2]
//输出：[1,2]

// 示例 5：
//输入：root = [1,null,2]
//输出：[1,2]

// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 533 👎 0

public class BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
        
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result =  new ArrayList<>();
        if (root == null){
            return result;  //这里当root为null需要返回的是result，尽量不要用null!
        }
        // 先访问根节点. 此处的 "访问" 不是打印, 而是插入 result 末尾
        result.add(root.val);
        // 递归处理左子树, 此时会得到一个左子树的遍历结果的 List. 这个结果也要加入到 result 中
        result.addAll(preorderTraversal(root.left));
        // 递归处理右子树
        result.addAll(preorderTraversal(root.right));
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}