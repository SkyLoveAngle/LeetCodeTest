package leetcode.editor.cn;

//根据一棵树的中序遍历与后序遍历构造二叉树。
// 注意: 
//你可以假设树中没有重复的元素。
//例如，给出
//中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树：
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 467 👎 0

public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        
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


/*
1.在后序遍历序列中,最后一个元素为树的根节点
2.在中序遍历序列中,根节点的左边为左子树，根节点的右边为右子树

根据中序遍历和后续遍历的特性我们进行树的还原过程分析:
1.首先在后序遍历序列中找到根节点(最后一个元素)
2.根据根节点在中序遍历序列中找到根节点的位置
3.根据根节点的位置将中序遍历序列分为左子树和右子树
4.根据根节点的位置确定左子树和右子树在中序数组和后续数组中的左右边界位置
5.递归构造左子树和右子树
6.返回根节点结束
 */

class Solution {
    public TreeNode buildTree(int[] inorder,int[] postorder){
        if (postorder == null || inorder==null){
            return null;
        }
        return buildtree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode buildtree(int[] inorder,int ileft,int iright,int[] postorder,int pleft,int pright){
        if (ileft > iright || pleft > pright){
            return null;
        }
        //根节点值为后续遍历最后一个
        TreeNode root = new TreeNode(postorder[pright]);
        //中序遍历第一个为起点
        int cur = ileft;
        //左子树节点个数为len
        int len =0;
        for (;cur<iright;cur++){
            //在中序遍历中找到根节点的位置
            if (inorder[cur] == postorder[pright]){
                break;
            }
            //记录左子树的长度
            len++;
        }

        //递归调用求解左右子树
        //左子树：中序遍历为第一个到根节点前一个，后续遍历为第一个到第一个+左子树长度-1
        root.left = buildtree(inorder,ileft,cur-1,postorder,pleft,pleft+len-1);
        //右子树：中序遍历为根节点后一个到最后，后续遍历为第一个+左子树节点长度到最后一个前面一个
        root.right = buildtree(inorder,cur+1,iright,postorder,pleft+len,pright-1);

        return root;

    }


//    int post_idx;
//    int[] postorder;
//    int[] inorder;
//    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();
//
//    //递归函数 helper(in_left, in_right)
//    //表示当前递归到中序序列中当前子树的左右边界，递归入口为helper(0, n - 1)
//    public TreeNode helper(int in_left, int in_right) {
//        // 如果这里没有节点构造二叉树了，就结束
//        if (in_left > in_right) {  //说明子树为空，返回空节点
//            return null;
//        }
//
//        // 选择 post_idx 位置的元素作为当前子树根节点
//        int root_val = postorder[post_idx];
//        TreeNode root = new TreeNode(root_val);
//
//        // 根据 root 所在位置分成左右两棵子树
//        int index = idx_map.get(root_val);
//
//        // 下标减一
//        post_idx--;
//        // 构造右子树
//        root.right = helper(index + 1, in_right);
//        // 构造左子树
//        root.left = helper(in_left, index - 1);
//        return root;
//    }
//
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        this.postorder = postorder;
//        this.inorder = inorder;
//        // 从后序遍历的最后一个元素开始
//        post_idx = postorder.length - 1;
//
//        // 建立（元素，下标）键值对的哈希表
//        int idx = 0;
//        for (Integer val : inorder) {
//            idx_map.put(val, idx++);
//        }
//
//        return helper(0, inorder.length - 1);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}