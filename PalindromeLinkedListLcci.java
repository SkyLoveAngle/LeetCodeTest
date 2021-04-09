package leetcode.editor.cn;

//编写一个函数，检查输入的链表是否是回文的。 
//
// 
//
// 示例 1： 
//
// 输入： 1->2
//输出： false 
// 
//
// 示例 2： 
//
// 输入： 1->2->2->1
//输出： true 
// 
//
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 
// 👍 51 👎 0

public class PalindromeLinkedListLcci{
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedListLcci().new Solution();
        
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
    public boolean isPalindrome(ListNode head) {
        //判断边界情况
        if (head == null || head.next ==null){
            return true;
        }
        //将原链表复制到一个新链表上
        ListNode newHead = new ListNode(0);//创建傀儡节点方便复制
        ListNode newTail = newHead;
        for (ListNode cur=head;cur!=null;cur=cur.next){
            newTail.next=new ListNode(cur.val);
            newTail=newTail.next;
        }
        //将新链表进行翻转逆置
        ListNode DummyNext = newHead.next;
        ListNode prev = null;
        ListNode cur = DummyNext;
        while(cur!=null){
            ListNode next = cur.next; //此处的next定义必须放在while循环里面，因为cur一直在变化，得保证next跟cur一同变化.
            if (next == null){ //此处cur走到了链表最后一个元素，该元素为逆置链表的头结点
                DummyNext=cur;
            }
            cur.next = prev;
            prev=cur;
            cur=next;
        }
        //对比两个链表是否回文
        ListNode cur1 = head;
        ListNode cur2 = DummyNext;
        while(cur1 != null && cur2 != null){
            if (cur1.val != cur2.val){
                return false;
            }
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}