package leetcode.editor.cn;

//根据一棵树的前序遍历与中序遍历构造二叉树。
// 注意:你可以假设树中没有重复的元素。
//
// 例如，给出
//前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
// 返回如下的二叉树：
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 942 👎 0

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        
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

/*中序遍历=左子树中序遍历+右子树中序遍历*/
class Solution {
    public int index =0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //为了让多个用例之间相互不影响，每次进入这个入口方法
        //都需要将index清空
        index =0;

        //当前给定的第2个参数表示中序遍历的结果=>int[]
        //为了让后面的操作方便，此处我们把int[]=>List<Integer>
        //方便后续代码中去截取中序遍历结果中的某个部分
        List<Integer> inorderList = new ArrayList<>();
        for (int i=0;i<inorder.length;i++){
            inorderList.add(inorder[i]);
        }
        return _buildTree(preorder,inorderList);
    }

    //第一个参数表示整个大的二叉树的先序结果，不管怎么递归，这个内容都是相同的！
    //第二各参数表示当前这个节点对应的子树的中序结果，这个会随着递归的进行而发生变化
    //如果当前的树是空树，此时inorder就是空的List
    public TreeNode _buildTree(int[] preorder,List<Integer> inorder){
        if (inorder.isEmpty()){
            return null;
        }
        if (index >= preorder.length){
            //遍历结束，已经把先序内容都访问完成
            return null;
        }
        //创建当前节点
        TreeNode root = new TreeNode(preorder[index]);
        index ++;
        //构建好一个节点之后就++，以备下次构建节点的时候能够读取到下一个元素
        //接下来进行递归，需要把左右子树的中序结果告诉递归方法
        //左右子树的中序结果就包含在当前这个树的中序遍历的结果中
        //中序结果 = 左子树的中序 + 根节点 + 右子树的中序
        //只要知道根节点在中序结果的位置，就能确定出左右子树
        int pos = inorder.indexOf(root.val);

        //左子树的中序：[0,pos)
        root.left = _buildTree(preorder,inorder.subList(0,pos));
        //右子树的中序：[pos+1,len)
        root.right = _buildTree(preorder,inorder.subList(pos+1,inorder.size()));

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}