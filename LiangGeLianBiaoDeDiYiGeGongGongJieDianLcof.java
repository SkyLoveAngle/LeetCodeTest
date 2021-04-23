package leetcode.editor.cn;

//输入两个链表，找出它们的第一个公共节点。如下面的两个链表：
// 在节点 c1 开始相交。
// 示例 1：
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
// 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
// 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

// 示例 2：
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。
// 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
// 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。

// 示例 3：
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
// 由于这两个链表不相交，所以 intersectVal 必须为 0，而skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。

// 注意：
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lis
//ts/ 
// 
// Related Topics 链表 
// 👍 175 👎 0

public class LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. 先求两个链表的长度
        int len1 = getLength(headA);
        int len2 = getLength(headB);
        // 2. 让长的链表先走
        if (len1 > len2) {
            int steps = len1 - len2;
            for (int i = 0; i < steps; i++) {
                headA = headA.next;
            }
        } else {
            int steps = len2 - len1;
            for (int i = 0; i < steps; i++) {
                headB = headB.next;
            }
        }
        // 3. 此时 headA 和 headB 已经在同一起跑线上了. 于是就同步往后走, 看能否相遇
        while (headA != null && headB != null) {
            // 此处比较的不是节点里的 val, 而是节点对象的身份.
            if (headA == headB) {
                // 相交了, 交点也找到了.
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public  int getLength(ListNode head){
        int length=0;
        for (ListNode cur =head;cur != null;cur=cur.next){
            length++;
        }
        return length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}