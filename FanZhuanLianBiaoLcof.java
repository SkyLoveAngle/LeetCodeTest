package leetcode.editor.cn;

//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
// 示例:
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
// 限制：
// 0 <= 节点个数 <= 5000
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 179 👎 0

public class FanZhuanLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head ==null){
            return null;
        }
        if (head.next==null){
            //连表里只有一个元素
            return head;
        }
        //处理一般情况
        ListNode newhead=null;
        ListNode prevNode=null;
        ListNode curNode=head;
        while(curNode!=null){
            //进入循环需要先设定好nextNode的位置
            ListNode nextNode =curNode.next;
            if (nextNode==null){
                //curNode指向链表的最后一个位置
                //也就是反转后新链表的头结点
                newhead = curNode;
            }
            //往回指
            curNode.next=prevNode;
            //更新位置，往下继续
            prevNode=curNode;
            curNode=nextNode;
        }
        return newhead;
    }

//        ListNode prev =null;
//        ListNode cur = head;
//        while (cur!=null){
//            ListNode next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur= next;
//        }
//        return prev;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}