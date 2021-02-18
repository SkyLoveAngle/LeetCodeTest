package leetcode.editor.cn;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 5587 👎 0

public class AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head =null,tail=null;//这里是创建了一个用于存放结果的新链表，初始化为空链表。
        int carray=0;//初始化进位为0
        while(l1!=null || l2!=null){

            int n1 = l1 != null ? l1.val : 0;
            //如果链表节点不为null，则将其值赋值给n，否则用0补位
            int n2 = l2 != null ? l2.val : 0;

            int sum = n1+n2+carray;//计算对应节点的和
            carray = sum/10;//取进位数

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            //先是创建了一个新的节点存放sum%10（这个数就是我们要存进新链表的元素）
            // 然后将tail.next的引用指向该元素，相当于一个链表尾插操作
            //最后再将tail的引用往后移一位

            if (l1!=null) l1=l1.next;
            if (l2!=null) l2=l2.next;
            //这里是判断L1和L2这两条链表是否已经到尾了，如果是则跳出，不食则继续下一个节点
        }
        if (carray>0){
            tail.next = new ListNode(carray);
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}